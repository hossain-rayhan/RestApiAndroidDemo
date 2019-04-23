package com.rayapplica.restapiandroiddemo;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.rayapplica.restapiandroiddemo.Adapter.QuestionAdapter;
import com.rayapplica.restapiandroiddemo.model.Data;
import com.rayapplica.restapiandroiddemo.model.Question;
import com.rayapplica.restapiandroiddemo.network.QuestionDataService;
import com.rayapplica.restapiandroiddemo.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private QuestionAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    QuestionDataService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create singleton instance of Retrofit Client and service
        service = RetrofitClient.getRetrofitInstance().create(QuestionDataService.class);
        //get user data and populate every time when the app launches
        getUserData();
    }

    //method for getting user data from the REST API
    private void getUserData(){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("...Loading...");
        progressDialog.show();

        Call<Data> call = service.getData();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                Log.e("On Failor Error", t.getMessage());
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //extract and populate user data from http response
    private void generateDataList(Data data){
        for (Question question : data.getQuestionList()){
            Log.e("Question", question.getTitle());
        }
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new QuestionAdapter(this, data.getQuestionList());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}

package com.rayapplica.restapiandroiddemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rayapplica.restapiandroiddemo.R;
import com.rayapplica.restapiandroiddemo.model.Question;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {
    private List<Question> questionList;
    private Context context;

    public QuestionAdapter(Context context, List<Question> userList) {
        this.questionList = userList;
        this.context = context;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.question_rv_custom_row, parent, false);
        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        holder.tvTitle.setText(questionList.get(position).getTitle());
        holder.tvOwner.setText(questionList.get(position).getOwner().getName());
        holder.tvViewCount.setText("" + questionList.get(position).getViewCount());
        holder.tvAnswerCount.setText("" + questionList.get(position).getAnswerCount());
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        TextView tvTitle;
        TextView tvOwner;
        TextView tvViewCount;
        TextView tvAnswerCount;

        public QuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            tvTitle = mView.findViewById(R.id.tvTitle);
            tvOwner = mView.findViewById(R.id.tvOwner);
            tvViewCount = mView.findViewById(R.id.tvViewCount);
            tvAnswerCount = mView.findViewById(R.id.tvAnswerCount);
        }
    }
}


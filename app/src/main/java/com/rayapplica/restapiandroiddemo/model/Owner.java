package com.rayapplica.restapiandroiddemo.model;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("user_id")
    private String id;
    @SerializedName("display_name")
    private String name;

    public String getName() {
        return name;
    }
}

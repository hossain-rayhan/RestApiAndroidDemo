package com.rayapplica.restapiandroiddemo.model;

import com.google.gson.annotations.SerializedName;

public class Question {
    @SerializedName("question_id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("view_count")
    long viewCount;
    @SerializedName("answer_count")
    long answerCount;
    @SerializedName("score")
    long score;
    @SerializedName("owner")
    Owner owner;

    public String getTitle() {
        return title;
    }

    public long getViewCount() {
        return viewCount;
    }

    public long getAnswerCount() {
        return answerCount;
    }

    public long getScore() {
        return score;
    }

    public Owner getOwner() {
        return owner;
    }
}

package com.redrock.date2.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alien on 2015/10/6.
 */
public class School {

    @SerializedName("school_id")
    private int id;
    @SerializedName("school_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

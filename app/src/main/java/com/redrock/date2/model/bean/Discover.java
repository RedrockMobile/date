package com.redrock.date2.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by alien on 2015/10/6.
 */
public class Discover implements Serializable {
    @SerializedName("discover_id")
    private int id;
    @SerializedName("discover_praise")
    private int praiseCount;
    @SerializedName("praise_status") //用户是否点赞, 1是0否
    private int praiseStatus;
    @SerializedName("discover_status")
    private int discoverStatus;  //发现状态, 0 结束 1 进行中
    @SerializedName("discover_time")
    private long time;  //截止时间
    @SerializedName("discover_title")
    private String title;
    @SerializedName("discover_caption") //副标题
    private String subheadTitle;
    @SerializedName("discover_picture")
    private String img;


    public int getDiscoverStatus() {
        return discoverStatus;
    }

    public void setDiscoverStatus(int discoverStatus) {
        this.discoverStatus = discoverStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(int praiseCount) {
        this.praiseCount = praiseCount;
    }

    public int getPraiseStatus() {
        return praiseStatus;
    }

    public void setPraiseStatus(int praiseStatus) {
        this.praiseStatus = praiseStatus;
    }

    public String getSubheadTitle() {
        return subheadTitle;
    }

    public void setSubheadTitle(String subheadTitle) {
        this.subheadTitle = subheadTitle;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

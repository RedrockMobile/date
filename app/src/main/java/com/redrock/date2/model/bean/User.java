package com.redrock.date2.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by zhuchenxi on 15/8/2.
 */
public class User implements Serializable{  //登录的时候获取的个人信息
    @SerializedName("uid")
    private int id;
    @SerializedName("avatar")
    private String face;
    @SerializedName("nickname")
    private String name;
    @SerializedName("signature")
    private String sign;
    @SerializedName("gender")
    private int gender;
    @SerializedName("role_id")
    private int role;
    @SerializedName("token")
    private String token;
    @SerializedName("fans")
    private int fansCount;
    @SerializedName("scan")
    private int attentionCount;
    @SerializedName("charm")
    private int charmValue;
    @SerializedName("realname")
    private String realName;
    @SerializedName("school")
    private String school;
    @SerializedName("signature")
    private String signature;
    @SerializedName("hobby")
    private String[] hobby;

    public User(int id, String face, String name, String sign, int gender, int role) {
        this.id = id;
        this.face = face;
        this.name = name;
        this.sign = sign;
        this.gender = gender;
        this.role = role;
    }

    public int getAttentionCount() {
        return attentionCount;
    }

    public void setAttentionCount(int attentionCount) {
        this.attentionCount = attentionCount;
    }

    public int getCharmValue() {
        return charmValue;
    }

    public void setCharmValue(int charmValue) {
        this.charmValue = charmValue;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public int getFansCount() {
        return fansCount;
    }

    public void setFansCount(int fansCount) {
        this.fansCount = fansCount;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

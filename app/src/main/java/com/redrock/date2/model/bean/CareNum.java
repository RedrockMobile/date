package com.redrock.date2.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alien on 2015/10/6.
 */
public class CareNum {

    @SerializedName("care_num")
    private int careNum;
    @SerializedName("cared_num")
    private int caredNum;

    public int getCareNum() {
        return careNum;
    }

    public void setCareNum(int careNum) {
        this.careNum = careNum;
    }

    public int getCaredNum() {
        return caredNum;
    }

    public void setCaredNum(int caredNum) {
        this.caredNum = caredNum;
    }
}

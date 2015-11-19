package com.redrock.date2.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alien on 2015/10/6.
 */
public class Letter {

    private String from;  //发件人
    @SerializedName("from_avatar")
    private String fromName;  //发件人呢称
    private String to;  //收件人
    @SerializedName("to_avatar")
    private String toName;
    private String content;
    private long time;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }
}

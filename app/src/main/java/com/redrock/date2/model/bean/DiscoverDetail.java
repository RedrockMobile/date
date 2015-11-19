package com.redrock.date2.model.bean;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
public class DiscoverDetail extends Discover{
    private long time;
    private String address;
    private String cost;
    private String content;
    private User[] member;
    private Comment[] comment;

    public Comment[] getComment() {

        return comment;
    }

    public void setComment(Comment[] comment) {
        this.comment = comment;
    }

    public User[] getMember() {
        return member;
    }

    public void setMember(User[] member) {
        this.member = member;
    }


    public long getTime() {

        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

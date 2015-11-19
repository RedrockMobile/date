package com.redrock.date2.moudel.date;

import android.os.Bundle;

import com.jude.beam.bijection.Presenter;
import com.jude.utils.JUtils;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.Comment;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
public class CommentPresenter extends Presenter<CommentActivity> {
    private int page;

    @Override
    protected void onCreate(CommentActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        loadMore();
    }

    @Override
    protected void onCreateView(CommentActivity view) {
        super.onCreateView(view);
    }

    public void loadMore(){
        DateModel.getInstance().getComments(getView().getIntent().getStringExtra("id"), page,new DataCallback<Comment[]>() {
            @Override
            public void success(String info, Comment[] data) {
                JUtils.Log("success");
                getView().addData(data);
                page++;
            }
        });
    }
}

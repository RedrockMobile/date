package com.redrock.date2.moudel.user;

import android.os.Bundle;

import com.jude.beam.bijection.Presenter;
import com.redrock.date2.model.UserModel;
import com.redrock.date2.model.bean.User;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class FansPresenter extends Presenter<FansActivity> {
    private String id;
    private User[] users;

    @Override
    protected void onCreate(FansActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        id = getView().getIntent().getStringExtra("id");
        UserModel.getInstance().getAttention("0", new DataCallback<User[]>() {
            @Override
            public void success(String info, User[] data) {
                getView().addData(users = data);
            }
        });
    }

    @Override
    protected void onCreateView(FansActivity view) {
        super.onCreateView(view);
        if (users!=null)getView().addData(users);
    }
}

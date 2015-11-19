package com.redrock.date2.moudel.action;

import android.os.Bundle;

import com.jude.beam.bijection.Presenter;
import com.redrock.date2.model.bean.DiscoverDetail;

/**
 * Created by Mr.Jude on 2015/8/14.
 */
public class ActionDetailPresenter extends Presenter<ActionDetailActivity> {
    private DiscoverDetail detail;

    @Override
    protected void onCreate(ActionDetailActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        getView().addLoadingView();
//        DiscoverModel.getInstance().getActionDetail(getView().getIntent().getStringExtra("id"), new DataCallback<DiscoverDetail>() {
//            @Override
//            public void success(String info, DiscoverDetail data) {
//                getView().removeLoadingView();
//                getView().setActionDetail(detail = data);
//            }
//        });
    }

    @Override
    protected void onCreateView(ActionDetailActivity view) {
        super.onCreateView(view);
        if (detail!=null)getView().setActionDetail(detail);
    }
}

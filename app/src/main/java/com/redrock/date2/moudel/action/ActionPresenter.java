package com.redrock.date2.moudel.action;

import android.os.Bundle;

import com.jude.beam.bijection.Presenter;
import com.redrock.date2.model.DiscoverModel;
import com.redrock.date2.model.bean.Discover;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit.Callback;
import retrofit.Response;

/**
 * Created by Mr.Jude on 2015/8/7.
 */
public class ActionPresenter extends Presenter<ActionFragment> {
    private int page = 0;
    private ArrayList<Discover> mDateArrayList = new ArrayList<>();

    @Override
    protected void onCreate(ActionFragment view, Bundle savedState) {
        super.onCreate(view, savedState);
        refresh();
    }

    @Override
    protected void onCreateView(ActionFragment view) {
        super.onCreateView(view);
        if (mDateArrayList != null && mDateArrayList.size() > 0) {
            getView().addDate((Discover[]) mDateArrayList.toArray());
        }
    }

    public void refresh() {
        DiscoverModel.getInstance().getDiscoverList(0, new Callback<Discover[]>() {
            @Override
            public void onResponse(Response<Discover[]> response) {
//                JUtils.Log("data-length"+response.body().length);
                getView().stopRefresh();
                mDateArrayList.clear();
                if(response.body()==null){
                    getView().showEmpty();
                    return;
                }
                if(response.body()!=null&&response.body().length>0){
                    getView().addDate(response.body());
                    mDateArrayList.addAll(Arrays.asList(response.body()));
                }
                if (response.body()!=null&&response.body().length < 20) {
                    getView().stopLoadMore();
                }
                page++;
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    public void loadMore() {
        DiscoverModel.getInstance().getDiscoverList(page, new Callback<Discover[]>() {
            @Override
            public void onResponse(Response<Discover[]> response) {
                getView().addDate(response.body());
                mDateArrayList.addAll(Arrays.asList(response.body()));
                if (response.body().length < 20) {
                    getView().stopLoadMore();
                }
                page++;
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}

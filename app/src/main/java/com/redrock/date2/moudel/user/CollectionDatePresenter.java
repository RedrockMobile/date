package com.redrock.date2.moudel.user;

import android.os.Bundle;

import com.jude.beam.bijection.Presenter;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.model.callback.DataCallback;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
public class CollectionDatePresenter extends Presenter<CollectionDateActivity> {
    private Date[] dates;

    private int page = 0;

    @Override
    protected void onCreate(CollectionDateActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        refresh();
    }

    @Override
    protected void onCreateView(CollectionDateActivity view) {
        super.onCreateView(view);
        if (dates!=null)getView().addData(dates);
    }

    public void refresh(){
        DateModel.getInstance().getCollection(0, new DataCallback<Date[]>() {
            @Override
            public void success(String info, Date[] data) {
                getView().clear();
                getView().addData(dates = data);
                page++;
            }
        });
    }

    public void loadMore(){
        DateModel.getInstance().getCollection(page,new DataCallback<Date[]>() {
            @Override
            public void success(String info, Date[] data) {
                getView().addData(data);
                page++;
            }
        });
    }
}

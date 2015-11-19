package com.redrock.date2.moudel.user;

import android.os.Bundle;
import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.redrock.date2.app.BaseRecyclerActivity;
import com.redrock.date2.model.bean.Date;
import com.redrock.date2.moudel.date.DateViewHolder;

/**
 * Created by Mr.Jude on 2015/8/11.
 */
@RequiresPresenter(CollectionDatePresenter.class)
public class CollectionDateActivity extends BaseRecyclerActivity<CollectionDatePresenter,Date> {

    @Override
    protected BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new DateViewHolder(parent);
    }

    @Override
    public void setRefreshAble() {
        super.setRefreshAble();
        getPresenter().refresh();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().loadMore();
    }
}

package com.redrock.date2.moudel.action;

import android.content.Context;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.redrock.date2.model.bean.Discover;

/**
 * Created by Mr.Jude on 2015/8/8.
 */
public class DiscoverAdapter extends RecyclerArrayAdapter<Discover> {
    public DiscoverAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DiscoverViewHolder(viewGroup);
    }
}

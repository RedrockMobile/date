package com.redrock.date2.moudel.action;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.tagview.TAGView;
import com.jude.utils.JUtils;
import com.redrock.date2.R;
import com.redrock.date2.model.bean.Discover;
import com.redrock.date2.moudel.date.CommentActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mr.Jude on 2015/8/8.
 */
public class DiscoverViewHolder extends BaseViewHolder<Discover> {
    @InjectView(R.id.image)
    SimpleDraweeView image;
    @InjectView(R.id.member)
    TextView member;
    @InjectView(R.id.comment)
    TextView comment;
    @InjectView(R.id.praise)
    TextView praise;
    @InjectView(R.id.ic_praise)
    ImageView icPraise;
    @InjectView(R.id.title)
    TextView title;
    @InjectView(R.id.tag)
    TAGView tag;
    @InjectView(R.id.ic_person)
    ImageView icPerson;

    public DiscoverViewHolder(ViewGroup parent) {
        super(parent, R.layout.action_item_main);
        ButterKnife.inject(this, itemView);
        comment.setOnClickListener(v -> {
            Intent i = new Intent(v.getContext(), CommentActivity.class);
            v.getContext().startActivity(i);
        });
        itemView.setOnClickListener(v -> {
            v.getContext().startActivity(new Intent(v.getContext(), ActionDetailActivity.class));
        });
    }

    @Override
    public void setData(Discover data) {
        image.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadii(JUtils.dip2px(2), JUtils.dip2px(2), 0, 0));
        if (data.getImg() != null)
            image.setImageURI(Uri.parse(data.getImg()));
        praise.setText(data.getPraiseCount());
        title.setText(data.getTitle());
        praise.setText(data.getPraiseCount()+"");
        if (data.getSubheadTitle()!=null&&!data.getSubheadTitle().isEmpty()){
            tag.setText(data.getSubheadTitle());
            tag.setVisibility(View.VISIBLE);
        }else{
            tag.setVisibility(View.INVISIBLE);
        }
    }
}

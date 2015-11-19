package com.redrock.date2.moudel.launch;

import android.content.Intent;
import android.os.Bundle;

import com.jude.beam.bijection.RequiresPresenter;
import com.redrock.date2.R;
import com.redrock.date2.app.BaseActivity;
import com.redrock.date2.moudel.main.MainActivity;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
@RequiresPresenter(LaunchPresenter.class)
public class LaunchActivity extends BaseActivity<LaunchPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_activity);
    }
}

package com.redrock.date2.moudel.launch;


import android.content.Intent;
import android.os.Bundle;

import com.jude.beam.bijection.Presenter;
import com.jude.http.RequestManager;
import com.jude.utils.JUtils;
import com.redrock.date2.config.API;
import com.redrock.date2.model.DateModel;
import com.redrock.date2.model.bean.DateTypeFather;
import com.redrock.date2.model.callback.DataCallback;
import com.redrock.date2.moudel.main.MainActivity;

/**
 * Created by Mr.Jude on 2015/8/13.
 */
public class LaunchPresenter extends Presenter<LaunchActivity> {

    @Override
    protected void onCreate(LaunchActivity view, Bundle savedState) {
        super.onCreate(view, savedState);
        RequestManager.getInstance().post(API.URL.DateType, null, new DataCallback<DateTypeFather[]>() {
            @Override
            public void success(String info, DateTypeFather[] data) {
                DateModel.getInstance().setDateType(data);
                getView(). startActivity(new Intent(getView(), MainActivity.class));
                getView().finish();
                for (DateTypeFather dateTypeFather : data) {
                    JUtils.Log(dateTypeFather.getName());
                }
            }

            @Override
            public void result(int status, String info) {
                super.result(status, info);
                if(DateModel.getInstance().getDateTypeFather() != null){
                    getView(). startActivity(new Intent(getView(), MainActivity.class));
                    getView().finish();
                }
            }

            @Override
            public void error(String errorInfo) {
                super.error(errorInfo);
                JUtils.Toast("网络错误，请检查网络");
            }
        });
    }
}

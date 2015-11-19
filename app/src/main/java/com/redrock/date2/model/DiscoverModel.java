package com.redrock.date2.model;

import android.content.Context;

import com.jude.beam.model.AbsModel;
import com.redrock.date2.config.API;
import com.redrock.date2.model.bean.Discover;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by alien on 2015/10/6.
 */
public class DiscoverModel extends AbsModel {

    private static Retrofit retrofit;

    @Override
    protected void onAppCreate(Context ctx) {
        super.onAppCreate(ctx);
    }

    public static DiscoverModel getInstance() {
        return getInstance(DiscoverModel.class);
    }


    public interface DiscoverService {
        @FormUrlEncoded
        @POST("discover/discoverlist")
        Call<Discover[]> getDiscoverList(@Header("uid") int id, @Header("token") String token, @Field("page") int page);
    }

    private Retrofit getRetrofit() {
        if (retrofit == null) {
            synchronized (this) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(API.URL.BASEURL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                }
            }
        }
        return retrofit;
    }

    public DiscoverService getDiscoverService() {
        return getRetrofit().create(DiscoverService.class);
    }

    //获取发现列表
    public void getDiscoverList(int page,Callback<Discover[]> callback){
        Call<Discover[]> call=getDiscoverService().getDiscoverList(UserModel.getInstance().getId(),
                UserModel.getInstance().getToken(), page);
        call.enqueue(callback);
    }

}

package com.example.specter.sampleapi3.Utilities;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by specter on 2/20/18.
 */

public class RetrofitHelper {

    private static Retrofit retrofit = null;
    static Retrofit getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();


        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.82:3000/api/mobile/manager/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();



        return retrofit;
    }
    public static RetrofitService getRetrofitService(){
        return getClient().create(RetrofitService.class);
    }
}

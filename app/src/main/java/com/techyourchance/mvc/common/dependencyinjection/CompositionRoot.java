package com.techyourchance.mvc.common.dependencyinjection;

import com.techyourchance.mvc.common.Constants;
import com.techyourchance.mvc.networking.StackOverFlowApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private Retrofit mRetrofit;

    public StackOverFlowApi getStackOverFlowApi() {
        return getRetrofit().create(StackOverFlowApi.class);
    }

    public Retrofit getRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

}

package com.example.dell.newsapi.common.manager;

import com.example.dell.newsapi.common.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by eshcerbinock on 3/21/18.
 */

/**
 * Api Manager that holds Retrofit instance and can manage all api settings.
 * Should be a Singleton because it's not needed to recreate Retrofit instance all the time.
 */
public class ApiManager {

    /**
     * Singleton instance.
     * <p>
     * This is a static field so we use "s"
     */
    private static ApiManager sInstance = null;

    /**
     * Retrofit instance. This is a class member so we use "m"
     */
    private Retrofit mRetrofit;

    /**
     * Private constructor
     */

    private ApiManager() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Singleton creational method
     *
     * @return {@link ApiManager} instance
     */
    public static ApiManager getInstance() {
        if (sInstance == null) {
            sInstance = new ApiManager();
        }
        return sInstance;
    }

    /**
     * Create Api Services
     *
     * @param serviceClass
     * @param <T>
     * @return
     */
    public <T> T createApiService(Class<T> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

}

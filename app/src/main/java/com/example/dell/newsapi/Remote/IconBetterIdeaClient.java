package com.example.dell.newsapi.Remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 3/19/2018.
 */

public class IconBetterIdeaClient {


    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://faviconget.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            // it was with ==> .baseUrl("https://icons.better-idea.org/")

        }

        return retrofit;
    }

}

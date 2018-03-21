package com.example.dell.newsapi.Interface;

import com.example.dell.newsapi.Model.IconBetterIdea;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by DELL on 3/19/2018.
 */

public interface IconBetterIdeaService {

    @GET
    Call<IconBetterIdea> getIconUrl(@Url String url);

}

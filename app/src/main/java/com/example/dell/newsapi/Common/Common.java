package com.example.dell.newsapi.Common;

import com.example.dell.newsapi.Interface.IconBetterIdeaService;
import com.example.dell.newsapi.Interface.NewsService;
import com.example.dell.newsapi.Remote.IconBetterIdeaClient;
import com.example.dell.newsapi.Remote.RetrofitClient;

/**
 * Created by DELL on 3/19/2018.
 */

public class Common {

    public static final String APK_KEY = "883063e20fa54d88a1654263b9d08aad";
    private static final String BASE_URL = "https://newsapi.org/";

    public static NewsService getNewsService() {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService() {
        return IconBetterIdeaClient.getClient().create(IconBetterIdeaService.class);
    }


}

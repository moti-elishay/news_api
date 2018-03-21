package com.example.dell.newsapi.Interface;

import com.example.dell.newsapi.Model.WebSite;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DELL on 3/19/2018.
 */

public interface NewsService {

    //Every method of an interface represents one possible API call.
    //It must have a HTTP annotation (GET, POST, etc.) to specify the request type and the relative URL.
    //
    // The return value wraps the response in a Call object with the type of the expected result.


    @GET("v2/sources?apiKey=883063e20fa54d88a1654263b9d08aad")
        //@GET("v2/sources?language=en&apiKey="+ Common.API_KEY)
    Call<WebSite> getSources();

}

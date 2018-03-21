package com.example.dell.newsapi.module.sources.model;

import com.example.dell.newsapi.common.ApiResponse;
import com.example.dell.newsapi.common.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by eshcerbinock on 3/21/18.
 */

public interface SourcesApiService {

    @GET(Constants.Api.Endpoint.Sources.FETCH_SOURCES)
    Call<ApiResponse> fetchSources(@Query(Constants.Api.Endpoint.Sources.Query.API_KEY) String apiKey);

}

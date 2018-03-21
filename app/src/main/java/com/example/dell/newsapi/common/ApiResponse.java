package com.example.dell.newsapi.common;

/**
 * Created by eshcerbinock on 3/21/18.
 */

import com.example.dell.newsapi.module.sources.entity.Source;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * We know that API response have the structure like:
 * {
 * "status": "ok",
 * "sources": List<{@link com.example.dell.newsapi.module.sources.entity.Source}>
 * }
 */
public class ApiResponse {

    @SerializedName(Constants.Model.Response.STATUS)
    private String mStatus;

    @SerializedName(Constants.Model.Response.SOURCES)
    private List<Source> mSources;

    /**
     * Getters
     */

    public String getStatus() {
        return mStatus;
    }

    public List<Source> getSources() {
        return mSources;
    }
}

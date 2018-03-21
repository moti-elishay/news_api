package com.example.dell.newsapi.module.sources.entity;

/**
 * Created by eshcerbinock on 3/21/18.
 */

import com.example.dell.newsapi.common.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Source API Model class
 */
public class Source {

    /**
     * {@link SerializedName} annotation used for Gson converting
     * "name" field from response into the "mName" field of our model.
     */

    @SerializedName(Constants.Model.Source.NAME)
    private String mName;

    @SerializedName(Constants.Model.Source.URL)
    private String mUrl;

    /**
     * Getters
     */

    public String getName() {
        return mName;
    }

    public String getUrl() {
        return mUrl;
    }

}
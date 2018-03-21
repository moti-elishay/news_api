package com.example.dell.newsapi.module.sources.view.adapter;

/**
 * Created by eshcerbinock on 3/21/18.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.dell.newsapi.R;
import com.example.dell.newsapi.module.sources.entity.Source;

/**
 * ViewHolder for holding views from {@link R.layout.list_item_source}
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView mTextViewSourceName;
    private TextView mTextViewSourceUrl;

    public ViewHolder(View itemView) {
        super(itemView);

        mTextViewSourceName = itemView.findViewById(R.id.text_view_source_name);
        mTextViewSourceUrl = itemView.findViewById(R.id.text_view_source_url);
    }

    public void bindWith(Source source) {
        mTextViewSourceName.setText(source.getName());
        mTextViewSourceUrl.setText(source.getUrl());
    }

}
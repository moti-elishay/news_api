package com.example.dell.newsapi.module.sources.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.newsapi.R;
import com.example.dell.newsapi.module.sources.entity.Source;

import java.util.List;

/**
 * Created by eshcerbinock on 3/21/18.
 */

public class RecyclerViewSourcesAdapter extends RecyclerView.Adapter<ViewHolder> {

    private Context mContext;
    private List<Source> mSources;

    public RecyclerViewSourcesAdapter(Context context, List<Source> sources) {
        mContext = context;
        mSources = sources;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_source, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Source currentSource = mSources.get(position);
        holder.bindWith(currentSource);
    }

    @Override
    public int getItemCount() {
        return mSources.size();
    }

}

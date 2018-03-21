package com.example.dell.newsapi.module.sources.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dell.newsapi.R;
import com.example.dell.newsapi.module.base.view.BaseActivity;
import com.example.dell.newsapi.module.sources.SourcesContract;
import com.example.dell.newsapi.module.sources.entity.Source;
import com.example.dell.newsapi.module.sources.presenter.SourcesPresenter;
import com.example.dell.newsapi.module.sources.view.adapter.RecyclerViewSourcesAdapter;

import java.util.List;

public class SourcesActivity extends BaseActivity<SourcesContract.View, SourcesContract.Presenter>
        implements SourcesContract.View {

    /**
     * The same as UI elements ids {@link R.layout.activity_main}
     * The variable name should also have a structure:
     * <p>
     * {componentName}{logicalDescription}
     * <p>
     * For example:
     * <p>
     * - mEditTextUserName
     * - mTextViewErrorDescription
     */
    private RecyclerView mRecyclerViewSources;
    private SwipeRefreshLayout mSwipeRefreshLayoutSources;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.fetchSources();
    }

    /**
     * {@link SourcesContract.View} implementation
     */
    @Override
    public void showSources(List<Source> sources) {
        RecyclerViewSourcesAdapter adapter = new RecyclerViewSourcesAdapter(this, sources);
        mRecyclerViewSources.setAdapter(adapter);
    }

    @Override
    public void hideLoading() {
        super.hideLoading();

        if (mSwipeRefreshLayoutSources.isRefreshing()) {
            mSwipeRefreshLayoutSources.setRefreshing(false);
        }
    }

    /**
     * {@link BaseActivity <{@link SourcesContract.View}, {@link SourcesContract.Presenter}>} methods
     */
    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected SourcesContract.Presenter getPresenter() {
        return new SourcesPresenter();
    }

    @Override
    protected void updateViewDependencies() {
        super.updateViewDependencies();

        mRecyclerViewSources = findViewById(R.id.recycler_view_sources);
        mRecyclerViewSources.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mSwipeRefreshLayoutSources = findViewById(R.id.swipe_refresh_sources);
        mSwipeRefreshLayoutSources.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.fetchSources();
            }
        });
    }
}

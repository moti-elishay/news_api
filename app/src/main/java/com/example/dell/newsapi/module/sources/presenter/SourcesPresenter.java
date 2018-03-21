package com.example.dell.newsapi.module.sources.presenter;

/**
 * Created by eshcerbinock on 3/21/18.
 */

import com.example.dell.newsapi.common.ApiResponse;
import com.example.dell.newsapi.common.Constants;
import com.example.dell.newsapi.common.manager.ApiManager;
import com.example.dell.newsapi.module.base.presenter.BasePresenter;
import com.example.dell.newsapi.module.sources.SourcesContract;
import com.example.dell.newsapi.module.sources.model.SourcesApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Sources Presenter
 * <p>
 * We inherited from {@link BasePresenter} so we should not implement base methods.
 * We should only implement methods that related to {@link SourcesContract.Presenter}
 */

public class SourcesPresenter extends BasePresenter<SourcesContract.View> implements SourcesContract.Presenter {

    private SourcesApiService mSourcesService;

    @Override
    public void onCreate(SourcesContract.View view) {
        super.onCreate(view);

        mSourcesService = ApiManager.getInstance().createApiService(SourcesApiService.class);
    }

    /**
     * {@link SourcesContract.Presenter} implementation
     */
    @Override
    public void fetchSources() {
        mView.get().showLoading("Fetching sources...");

        mSourcesService.fetchSources(Constants.Api.KEY).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                mView.get().hideLoading();

                try {
                    mView.get().showSources(response.body().getSources());
                } catch (NullPointerException exception) {
                    mView.get().showError(exception.getLocalizedMessage());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                mView.get().hideLoading();
                mView.get().showError(t.getLocalizedMessage());
            }
        });
    }

}
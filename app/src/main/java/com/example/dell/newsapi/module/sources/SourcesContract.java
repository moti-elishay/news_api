package com.example.dell.newsapi.module.sources;

import com.example.dell.newsapi.module.base.BaseContract;
import com.example.dell.newsapi.module.sources.entity.Source;

import java.util.List;

/**
 * Created by eshcerbinock on 3/21/18.
 */

/**
 * Contract for View and Presenter in Sources module.
 */
public interface SourcesContract {

    /**
     * We should understand that this View should show the List of sources
     * <p>
     * We inherited from {@link BaseContract.View} so we know that our view also can:
     * - showLoading()
     * - hideLoading()
     * - showError()
     */
    interface View extends BaseContract.View {

        void showSources(List<Source> sources);

    }

    /**
     * We should understand that this Presenter should fetch sources
     * <p>
     * We inherited from {@link BaseContract.Presenter} so we know that our presenter also can:
     * - onCreate()
     * - onDestroy()
     */
    interface Presenter extends BaseContract.Presenter<View> {

        void fetchSources();

    }

}

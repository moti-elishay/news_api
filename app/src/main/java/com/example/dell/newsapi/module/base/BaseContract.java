package com.example.dell.newsapi.module.base;

/**
 * Created by eshcerbinock on 3/21/18.
 */


/**
 * Base contract between View and Presenter
 */
public interface BaseContract {

    /**
     * We can suppose that every View should implement this method
     */
    interface View {

        void showError(String message);

        void showLoading(String message);

        void hideLoading();
    }

    /**
     * We can suppose that every presenter should implement this method
     *
     * @param <V> ViewType. Should extending {@link BaseContract.View}
     */
    interface Presenter<V extends View> {

        void onCreate(V view);

        void onDestroy();

    }

}

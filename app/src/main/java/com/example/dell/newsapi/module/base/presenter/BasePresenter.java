package com.example.dell.newsapi.module.base.presenter;

import com.example.dell.newsapi.module.base.BaseContract;

import java.lang.ref.WeakReference;

/**
 * Created by eshcerbinock on 3/21/18.
 */

/**
 * Base Presenter class.
 * Should implement {@link com.example.dell.newsapi.module.base.BaseContract.Presenter <{@link BaseContract.View}>} methods.
 * <p>
 * We use this for avoiding the implementation of base methods in every Presenter
 *
 * @param <V> - View interface which will be implemented by Activity
 */
public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter<V> {

    /**
     * We know that every Presenter will have a View but we don't know the concrete realization.
     * So we use generic. You will see how it works in next Presenter.
     * <p>
     * Should be protected for we can take this from childs.
     */
    protected WeakReference<V> mView;

    /**
     * {@link BaseContract.Presenter <{@link BaseContract.View}>} implementation.
     */
    @Override
    public void onCreate(V view) {
        mView = new WeakReference<>(view);
    }

    @Override
    public void onDestroy() {
        mView = null;
    }

}

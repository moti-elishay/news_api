package com.example.dell.newsapi.module.base.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.dell.newsapi.module.base.BaseContract;

/**
 * Created by eshcerbinock on 3/21/18.
 */


/**
 * Base Activity class.
 * Should implement {@link com.example.dell.newsapi.module.base.BaseContract.View} methods.
 * <p>
 * We use this for avoiding the implementation of base methods in every Activity
 *
 * @param <V> - View interface which will be implemented by Activity
 * @param <P> - Presenter interface which will be connected with Activity
 */

public abstract class BaseActivity<V extends BaseContract.View, P extends BaseContract.Presenter<V>>
        extends AppCompatActivity implements BaseContract.View {

    /**
     * We know that every activity will have a Presenter but we don't know the concrete realization.
     * So we use generic. You will see how it works in next Activity.
     * <p>
     * Should be protected for we can take this from childs.
     */
    protected P mPresenter;

    /**
     * Can be private because we work with this only in this class.
     */
    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        updateViewDependencies();

        mPresenter = getPresenter();
        mPresenter.onCreate((V) this);
    }

    /**
     * {@link BaseContract.View} implementation
     */

    @Override
    public void showError(String message) {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle("Error")
                .setMessage(message)
                .create().show();
    }

    @Override
    public void showLoading(String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(message);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setIndeterminate(true);
        }

        if (!mProgressDialog.isShowing()) {
            mProgressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog == null) {
            return;
        }

        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    /**
     * Abstract method for this class childs
     *
     * @return id of content view layout
     */
    abstract protected int getContentViewId();

    /**
     * @return instance of {@link BaseContract.Presenter <{@link V}>} concrete realization
     */
    abstract protected P getPresenter();

    /**
     * Method for updating some dependencies if needed.
     */
    protected void updateViewDependencies() {
    }

}

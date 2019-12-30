package com.bawei.myapplication.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;


public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {
protected P  mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        ButterKnife.bind(this);
        mPresenter=protectedPresenter();
        if (mPresenter != null) {
            mPresenter.attach(this);
        }
        initView();
        initDate();

    }

    protected abstract int layoutId();

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract P protectedPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.datach();
        }
    }
}

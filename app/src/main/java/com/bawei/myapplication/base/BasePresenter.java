package com.bawei.myapplication.base;

/**
 * @包名 com.bawei.mengxuan.base
 * @mengxuan
 * @日期2019/12/25
 * @日期2019 : 12:25
 * @项目名MengXuan20191225
 * @类名BsaePresenter
 **/
public abstract class BasePresenter<V> {
    protected V view;

    public BasePresenter() {
        initModel();
    }

    public void attach(V view) {
        this.view = view;
    }

    public void datach() {
        view = null;
    }

    protected abstract void initModel();
}

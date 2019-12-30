package com.bawei.myapplication.presenter;

import com.bawei.myapplication.base.BasePresenter;
import com.bawei.myapplication.contract.IContract;
import com.bawei.myapplication.model.Model;
import com.bawei.myapplication.presenter.band.Band;

/**
 * @包名 com.bawei.myapplication.presenter
 * @mengxuan
 * @日期2019/12/29
 * @日期2019 : 12:29
 * @项目名MyApplication7
 * @类名Presenter
 **/
public class Presenter extends BasePresenter<IContract.IView> implements IContract.IPresenter {

    private Model model;

    @Override
    protected void initModel() {
        model = new Model();
    }

    @Override
    public void homeDate() {
        model.homeDate(new IContract.IModel.IMView() {
            @Override
            public void homeSuccess(Band band) {
                view.homeSuccess(band);
            }

            @Override
            public void homeFine(Throwable throwable) {
                view.homeFine(throwable);
            }
        });
    }
}

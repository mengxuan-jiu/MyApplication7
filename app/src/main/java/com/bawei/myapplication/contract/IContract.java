package com.bawei.myapplication.contract;


import com.bawei.myapplication.presenter.band.Band;

/**
 * @包名 com.bawei.mengxuan.contract
 * @mengxuan
 * @日期2019/12/25
 * @日期2019 : 12:25
 * @项目名MengXuan20191225
 * @类名IContract
 **/
public interface IContract {
    interface IView{
        void homeSuccess(Band band);
        void homeFine(Throwable throwable);


    }
    interface IPresenter{
        void homeDate();


    }

    interface IModel{
        void homeDate(IMView imView);
        interface IMView{
            void homeSuccess(Band band);
            void homeFine(Throwable throwable);


        }


    }
}

package com.bawei.myapplication.model;

import com.bawei.myapplication.contract.IContract;
import com.bawei.myapplication.presenter.band.Band;
import com.bawei.myapplication.util.NetUtil;
import com.google.gson.Gson;

/**
 * @包名 com.bawei.myapplication.model
 * @mengxuan
 * @日期2019/12/29
 * @日期2019 : 12:29
 * @项目名MyApplication7
 * @类名Model
 **/
public class Model implements IContract.IModel {
    @Override
    public void homeDate(IMView imView) {
        NetUtil.getInstance().getJson("http://blog.zhaoliang5156.cn/api/shop/fulishe1.json", new NetUtil.IMycallBack() {
            @Override
            public void doGetString(String s) {
                Band band = new Gson().fromJson(s, Band.class);
                imView.homeSuccess(band);
            }

            @Override
            public void doErroe(Throwable throwable) {
                imView.homeFine(throwable);
            }
        });
    }
}

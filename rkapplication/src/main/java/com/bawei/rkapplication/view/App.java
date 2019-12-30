package com.bawei.rkapplication.view;

import android.app.Application;

/**
 * @包名 com.bawei.rkapplication.view
 * @mengxuan
 * @日期2019/12/30
 * @日期2019 : 12:30
 * @项目名MyApplication7
 * @类名App
 **/
public class App extends Application {
    public static App app;
    @Override
    public void onCreate() {
        super.onCreate();
   app=this;
    }
}

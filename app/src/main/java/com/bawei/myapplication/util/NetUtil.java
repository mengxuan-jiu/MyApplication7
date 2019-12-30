package com.bawei.myapplication.util;


import android.os.Handler;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


/**
 * @包名 com.bawei.myapplication
 * @mengxuan
 * @日期2019/12/27
 * @日期2019 : 12:27
 * @项目名MyApplication6
 * @类名NetUtil
 **/
public class NetUtil {
    private static NetUtil netUtil;
    private final OkHttpClient okHttpClient;
    private final Handler handler;


    private NetUtil() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor httpLoggingInterceptor1 = httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor1)
                .build();
        handler = new Handler();
    }

    public static NetUtil getInstance() {

        if (netUtil == null) {
            synchronized (NetUtil.class) {
                if (netUtil == null) {

                    netUtil = new NetUtil();
                }
            }
        }
        return netUtil;
    }

    public void getJson(String util, IMycallBack iMycallBack) {
        Request request = new Request.Builder()
                .get()
                .url(util)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iMycallBack.doErroe(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null && response.isSuccessful()) {

                    String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iMycallBack.doGetString(string);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iMycallBack.doErroe(new Exception("xxx"));
                        }
                    });
                }


            }
        });


    }

    //////////////////////////////////
    public void postJson(String util, Map<String, String> map, IMycallBack iMycallBack) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : map.keySet()) {
            String values = map.get(key);
            builder.add(key, values);

        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder()
                .post(formBody)
                .url(util)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iMycallBack.doErroe(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response != null && response.isSuccessful()) {

                    String string = response.body().string();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iMycallBack.doGetString(string);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            iMycallBack.doErroe(new Exception("xxx"));
                        }
                    });
                }


            }
        });


    }

    //////////////////////////////
    public interface IMycallBack {
        void doGetString(String s);
        void doErroe(Throwable throwable);
    }
}

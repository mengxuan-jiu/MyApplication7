package com.bawei.rkapplication.util;

import android.os.Handler;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.rkapplication.view.App;

import okhttp3.OkHttpClient;

/**
 * @包名 com.bawei.rkapplication.util
 * @mengxuan
 * @日期2019/12/30
 * @日期2019 : 12:30
 * @项目名MyApplication7
 * @类名NetnUtl
 **/
public class NetUtl {
    private static NetUtl netnUtl;
    private final Handler handler;
  //  private final OkHttpClient okHttpClient;
    private final RequestQueue requestQueue;

    private NetUtl() {
        handler = new Handler();
      //  okHttpClient = new OkHttpClient();
        requestQueue = Volley.newRequestQueue(App.app);
    }

    public static NetUtl getInstance() {
        if (netnUtl == null) {
            synchronized (NetUtl.class) {
                if (netnUtl == null) {
                    netnUtl = new NetUtl();
                }
            }
        }
        return netnUtl;
    }

    public void getJson(String u, final IContBack iContBack) {
        // okHttpClient.connectTimeoutMillis();
        StringRequest stringRequest = new StringRequest(StringRequest.Method.GET, u, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                iContBack.getString(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                iContBack.error(error);
            }
        });
        requestQueue.add(stringRequest);
    }

    public interface IContBack {
        void getString(String s);

        void error(Throwable throwable);
    }
}

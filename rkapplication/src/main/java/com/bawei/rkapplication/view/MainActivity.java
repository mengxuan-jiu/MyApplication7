package com.bawei.rkapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.bawei.rkapplication.R;
import com.bawei.rkapplication.presenter.bane.Bane;
import com.bawei.rkapplication.util.NetUtl;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.m_text);
        NetUtl.getInstance().getJson("http://172.17.8.100/small/commodity/v1/bannerShow", new NetUtl.IContBack() {
            @Override
            public void getString(String s) {
//                Bane bane = new Gson().fromJson(s, Bane.class);
//                String s1 = bane.toString();
                textView.setText(s);
            }

            @Override
            public void error(Throwable throwable) {

            }
        });
    }
}

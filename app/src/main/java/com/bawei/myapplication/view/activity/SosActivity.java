package com.bawei.myapplication.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.myapplication.R;
import com.bawei.myapplication.base.BaseActivity;
import com.bawei.myapplication.base.BasePresenter;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SosActivity extends BaseActivity {

    private Button button,ss_bottom;
    private ImageView imageView;

    @Override
    protected int layoutId() {
        return R.layout.activity_sos;
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView() {
        CodeUtils.init(this);
        button = findViewById(R.id.s_button);
        imageView = findViewById(R.id.s_image);
        ss_bottom = findViewById(R.id.ss_bottom);
        ss_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new Bean("wang", 28));
            }
        });
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
             //   EventBus.getDefault().post("ddddddd");
                Bitmap image = CodeUtils.createImage("1795222", 444, 444, null);
                imageView.setImageBitmap(image);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CodeUtils.analyzeByImageView(imageView, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(SosActivity.this, ""+result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(SosActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected BasePresenter protectedPresenter() {
        return null;
    }



    @Override
    protected void onStart() {
        super.onStart();
       EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onGetXxxBean(Bean bean) {
        Toast.makeText(this, "成功"+bean.toString(), Toast.LENGTH_SHORT).show();
    }
    @Subscribe
    public void onGetString(String string) {
        Toast.makeText(this, "成功s", Toast.LENGTH_SHORT).show();
    }
}

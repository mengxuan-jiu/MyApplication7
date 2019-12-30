package com.bawei.myapplication.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.myapplication.R;
import com.bawei.myapplication.base.BaseActivity;
import com.bawei.myapplication.contract.IContract;
import com.bawei.myapplication.presenter.Presenter;
import com.bawei.myapplication.presenter.band.Band;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity<Presenter> implements IContract.IView {



    @BindView(R.id.m_RecyclerView)
    RecyclerView mRecyclerView;


    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initDate() {

        mPresenter.homeDate();
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    }

    @Override
    protected void initView() {
        mRecyclerView = findViewById(R.id.m_RecyclerView);

    }


    @Override
    protected Presenter protectedPresenter() {
        return new Presenter();
    }

    @Override
    public void homeSuccess(Band band) {
        List<Band.DataBean> list = band.getData();
        MyAdapter myAdapter = new MyAdapter(list);

        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setMyonClickListener(new MyAdapter.OnClickListener() {
            @Override
            public void clickListener(int i) {
                Intent intent = new Intent(MainActivity.this, SosActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void homeFine(Throwable throwable) {

    }



}

package com.bawei.myapplication.view.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.myapplication.R;
import com.bawei.myapplication.presenter.band.Band;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @包名 com.bawei.myapplication.view.activity
 * @mengxuan
 * @日期2019/12/29
 * @日期2019 : 12:29
 * @项目名MyApplication7
 * @类名MyAdapter
 **/
class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private List<Band.DataBean> list;

    public MyAdapter(List<Band.DataBean> list) {

        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new MyViewHolder(View.inflate(parent.getContext(), R.layout.ll, null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Band.DataBean bean = list.get(position);
        holder.llText.setText(bean.getGoods_name());
        Glide.with(holder.itemView).load(bean.getGoods_thumb())
                
                .into(holder.llImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View view) {
                myOnClickListener.clickListener(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static
    class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView llImage;

        TextView llText;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            llImage = itemView.findViewById(R.id.ll_image);
            llText = itemView.findViewById(R.id.ll_text);
        }
    }
    OnClickListener myOnClickListener;

    public void setMyonClickListener(OnClickListener myonClickListener) {
        this.myOnClickListener = myonClickListener;
    }

    public interface OnClickListener{
        void clickListener(int i);
    }
}

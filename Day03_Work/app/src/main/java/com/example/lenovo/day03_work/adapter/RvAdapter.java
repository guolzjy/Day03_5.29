package com.example.lenovo.day03_work.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.day03_work.R;
import com.example.lenovo.day03_work.entityclass.HomeList;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeList.DataBean.DatasBean> list;

    public RvAdapter(Context context, ArrayList<HomeList.DataBean.DatasBean> list) {
        this.context = context;
        this.list = list;
    }

    public void setList(ArrayList<HomeList.DataBean.DatasBean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.rv_item, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeList.DataBean.DatasBean bean = list.get(position);
        Glide.with(context).load(bean.getEnvelopePic()).into(holder.iv_rv_item);
        holder.tv_rv_item.setText(bean.getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_rv_item;
        private TextView tv_rv_item;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_rv_item = itemView.findViewById(R.id.iv_rv_item);
            tv_rv_item = itemView.findViewById(R.id.tv_rv_item);
        }
    }
}

package com.bwie.copejingdong.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.copejingdong.R;
import com.bwie.copejingdong.entity.RightGoodsBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/20
 */
public class InnerRecyclerAdapterRight extends RecyclerView.Adapter<InnerRecyclerAdapterRight.ViewHolder> {
    private Context context;
    private List<RightGoodsBean.DataBean.ListBean> dataBeansa = new ArrayList<>();

    public InnerRecyclerAdapterRight(Context context, List<RightGoodsBean.DataBean.ListBean> dataBeans) {
        this.context = context;
        if (dataBeans != null) {
            this.dataBeansa = dataBeans;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.layout_right2, parent, false);
        ViewHolder holder = new ViewHolder(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(dataBeansa.get(position).getName());
        Picasso.with(context).load(dataBeansa.get(position).getIcon()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataBeansa == null ? 0 : dataBeansa.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textviewaa);
            imageView = itemView.findViewById(R.id.iv_pic);
        }
    }

}

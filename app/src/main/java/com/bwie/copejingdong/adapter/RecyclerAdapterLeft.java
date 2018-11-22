package com.bwie.copejingdong.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.copejingdong.R;
import com.bwie.copejingdong.entity.LeftKindBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/20
 */
public class RecyclerAdapterLeft extends RecyclerView.Adapter<RecyclerAdapterLeft.ViewHolder> {
    private Context context;
    private List<LeftKindBean.DataBean> list = new ArrayList<>();

    public RecyclerAdapterLeft(Context context, List<LeftKindBean.DataBean> list) {
        this.context = context;
        if (list != null && list.size() > 0) {
            this.list = list;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.layout_leftkind, parent, false);
        ViewHolder holder = new ViewHolder(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_letkind);
            textView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.clicka(v, getAdapterPosition() + 1);
            }
        }
    }

    public interface ClickListener {
        void clicka(View v, int position);
    }

    private ClickListener clickListener;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
}

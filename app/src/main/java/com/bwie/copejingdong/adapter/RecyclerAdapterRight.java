package com.bwie.copejingdong.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.copejingdong.R;
import com.bwie.copejingdong.entity.RightGoodsBean;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/20
 */
public class RecyclerAdapterRight extends RecyclerView.Adapter<RecyclerAdapterRight.ViewHolder> {
    private Context context;
    private List<RightGoodsBean.DataBean> dataBeans = new ArrayList<>();
    private InnerRecyclerAdapterRight innerRecyclerAdapterRight;

    public RecyclerAdapterRight(Context context, List<RightGoodsBean.DataBean> dataBeans) {
        this.context = context;
        if (dataBeans != null) {
            this.dataBeans = dataBeans;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(context).inflate(R.layout.layout_right1, parent, false);
        ViewHolder holder = new ViewHolder(itemview);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(dataBeans.get(position).getName());
        List<RightGoodsBean.DataBean.ListBean> list = dataBeans.get(position).getList();

        innerRecyclerAdapterRight = new InnerRecyclerAdapterRight(context, list);
        holder.innerRecycle.setAdapter(innerRecyclerAdapterRight);
        holder.innerRecycle.setLayoutManager(new GridLayoutManager(context, 3));
    }

    @Override
    public int getItemCount() {
        return dataBeans == null ? 0 : dataBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        RecyclerView innerRecycle;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt_right);
            innerRecycle = itemView.findViewById(R.id.innerrecycleview);

        }
    }

}

package com.bwie.copejingdong.goodskind;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bwie.copejingdong.R;
import com.bwie.copejingdong.adapter.RecyclerAdapterLeft;
import com.bwie.copejingdong.adapter.RecyclerAdapterRight;
import com.bwie.copejingdong.entity.LeftKindBean;
import com.bwie.copejingdong.entity.RightGoodsBean;

import java.util.List;

public class GoodsKindsActivity extends AppCompatActivity implements GoodsKindView {

    private RecyclerView mRecyclerviewLeft;
    private RecyclerView mRecyclerviewRight;
    private GoodsKindPresenter goodsKindPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_kinds);
        initView();
        goodsKindPresenter = new GoodsKindPresenter(this);
        //获取左边
        goodsKindPresenter.getGoodskind();
    }

    private void initView() {
        mRecyclerviewLeft = findViewById(R.id.recyclerview_left);
        mRecyclerviewRight = findViewById(R.id.recyclerview_right);


    }

    @Override
    public void success(List<LeftKindBean.DataBean> list) {
        RecyclerAdapterLeft recyclerAdapterLeft = new RecyclerAdapterLeft(this, list);
        mRecyclerviewLeft.setAdapter(recyclerAdapterLeft);
        mRecyclerviewLeft.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerviewLeft.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerviewLeft.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerAdapterLeft.setClickListener(new RecyclerAdapterLeft.ClickListener() {
            @Override
            public void clicka(View v, int position) {
                goodsKindPresenter.getGoodsShow(position);
            }
        });
    }

    @Override
    public void successa(List<RightGoodsBean.DataBean> listaa) {
        RecyclerAdapterRight recyclerAdapterRight = new RecyclerAdapterRight(this, listaa);
        mRecyclerviewRight.setAdapter(recyclerAdapterRight);
        mRecyclerviewRight.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void fail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void faila(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}

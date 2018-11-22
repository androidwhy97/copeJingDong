package com.bwie.copejingdong.goodskind;

import com.bwie.copejingdong.entity.LeftKindBean;
import com.bwie.copejingdong.entity.RightGoodsBean;
import com.bwie.copejingdong.utils.HttpCallBack;
import com.google.gson.Gson;

import java.util.List;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/20
 */
public class GoodsKindPresenter {
    private final GoodsKindModel goodsKindModel;
    private GoodsKindView goodsKindView;

    public GoodsKindPresenter(GoodsKindView goodsKindView) {
        this.goodsKindView = goodsKindView;
        goodsKindModel = new GoodsKindModel();
    }

    public void getGoodskind() {
        goodsKindModel.getGoodKind(new HttpCallBack() {
            @Override
            public void successful(String result) {
                Gson gson = new Gson();
                LeftKindBean leftKindBean = gson.fromJson(result, LeftKindBean.class);
                List<LeftKindBean.DataBean> dataBeans = leftKindBean.getData();
                goodsKindView.success(dataBeans);
            }

            @Override
            public void failer(String error) {
                goodsKindView.fail(error);
            }
        });
    }

    public void getGoodsShow(final int position) {
        goodsKindModel.getGoodShow(position, new HttpCallBack() {
            @Override
            public void successful(String result) {
                Gson gson = new Gson();
                RightGoodsBean rightGoodsBean = gson.fromJson(result, RightGoodsBean.class);
                List<RightGoodsBean.DataBean> dataBeans = rightGoodsBean.getData();
                if (dataBeans != null) {
                    goodsKindView.successa(dataBeans);
                }else{
                        goodsKindView.faila("数据为空");
                }

            }

            @Override
            public void failer(String error) {
                goodsKindView.faila(error);
            }
        });
    }
}

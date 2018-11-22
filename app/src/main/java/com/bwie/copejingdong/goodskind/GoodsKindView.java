package com.bwie.copejingdong.goodskind;

import com.bwie.copejingdong.entity.LeftKindBean;
import com.bwie.copejingdong.entity.RightGoodsBean;

import java.util.List;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/20
 */
public interface GoodsKindView {
    void success(List<LeftKindBean.DataBean> list);
    void successa(List<RightGoodsBean.DataBean> listaa);
    void fail(String error);
    void faila(String error);
}

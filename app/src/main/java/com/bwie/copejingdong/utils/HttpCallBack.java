package com.bwie.copejingdong.utils;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/9
 */
public interface HttpCallBack {
    void successful(String result);
    void failer(String error);
}

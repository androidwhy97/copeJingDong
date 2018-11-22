package com.bwie.copejingdong.register;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/9
 */
public interface RegisterView {
    void onSuccess(String result);

    void onFail(String msg);
}

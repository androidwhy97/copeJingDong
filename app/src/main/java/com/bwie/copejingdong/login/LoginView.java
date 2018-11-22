package com.bwie.copejingdong.login;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/9
 */
public interface LoginView {
    void onSuccess(String result);

    void onFail(String msg);
}

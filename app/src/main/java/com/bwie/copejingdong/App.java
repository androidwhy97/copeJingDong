package com.bwie.copejingdong;

import android.app.Application;

import com.bwie.copejingdong.utils.OkUtils;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/20
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        OkUtils.init();
    }
}

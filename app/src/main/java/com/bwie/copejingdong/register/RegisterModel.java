package com.bwie.copejingdong.register;

import android.text.TextUtils;

import com.bwie.copejingdong.entity.Bean;
import com.bwie.copejingdong.utils.HttpCallBack;
import com.bwie.copejingdong.utils.HttpHelpter;
import com.bwie.copejingdong.utils.UrlHolder;
import com.google.gson.Gson;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/9
 */
public class RegisterModel {
    public void register(String name, String pwd, final HttpCallBack httpCallBack) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)) {
            httpCallBack.failer("闹呢,大哥!你见过用户名或者密码为空吗");
            return;
        }
        //对账号密码进行处理
        String par = "?mobile=" + name + "&password=" + pwd;
        HttpHelpter.getInstance().doGet(UrlHolder.REGISTER_URL + par).result(new HttpHelpter.HttpListener() {
            @Override
            public void success(String data) {
                Gson gson = new Gson();
                Bean bean =gson.fromJson(data, Bean.class);
                String msg = bean.getMsg();
                String code = bean.getCode();
                switch (code) {
                    case "0":
                        httpCallBack.successful(msg);
                        break;
                    case "1":
                        httpCallBack.failer(msg);
                        break;
                }
            }
        });
    }
}

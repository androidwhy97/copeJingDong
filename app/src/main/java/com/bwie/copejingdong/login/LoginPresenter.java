package com.bwie.copejingdong.login;

import android.util.Log;

import com.bwie.copejingdong.utils.HttpCallBack;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/9
 */
public class LoginPresenter {
    private final LoginModel loginModel;
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel();
    }

    public void login(String name, String pwd) {
        loginModel.login(name, pwd, new HttpCallBack() {
            @Override
            public void successful(String result) {
                loginView.onSuccess(result);
                Log.i("123", "successful: "+result);
            }

            @Override
            public void failer(String error) {
                loginView.onFail(error);
                Log.i("123", "failer: "+error);
            }
        });
    }
}

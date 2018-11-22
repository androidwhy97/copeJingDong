package com.bwie.copejingdong.register;

import com.bwie.copejingdong.utils.HttpCallBack;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/9
 */
public class RegisterPresenter {
    private final RegisterModel registerModel;
    private RegisterView registerView;

    public RegisterPresenter(RegisterView registerView) {
        this.registerView = registerView;
        registerModel = new RegisterModel();
    }

    public void register(String name, String pwd) {
        registerModel.register(name, pwd, new HttpCallBack() {
            @Override
            public void successful(String result) {
                registerView.onSuccess(result);
            }

            @Override
            public void failer(String error) {
                registerView.onFail(error);
            }
        });

    }
}

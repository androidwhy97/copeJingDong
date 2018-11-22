package com.bwie.copejingdong.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.copejingdong.MainActivity;
import com.bwie.copejingdong.R;
import com.bwie.copejingdong.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private LoginPresenter loginPresenter;
    private EditText name;
    private EditText pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter(this);
        name = findViewById(R.id.username);
        pwd = findViewById(R.id.passwordzzz);
        Button btn_login = findViewById(R.id.btn_login);
        Button btn_toregister = findViewById(R.id.btn_jump_register);
        btn_toregister.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        sp.edit().putBoolean("is_login", true).commit();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //跳转注册
            case R.id.btn_jump_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            //登录
            case R.id.btn_login:
                //获取输入的值
                String mobile = name.getText().toString().trim();
                String passw = pwd.getText().toString().trim();
                loginPresenter.login(mobile, passw);
                break;
        }
    }
}

package com.bwie.copejingdong.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.copejingdong.R;
import com.bwie.copejingdong.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    private EditText name;
    private EditText pwd;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerPresenter = new RegisterPresenter(this);
        name = findViewById(R.id.usernamezz);
        pwd = findViewById(R.id.passwordaa);
        Button btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = name.getText().toString().trim();
                String passw = pwd.getText().toString().trim();
                registerPresenter.register(mobile, passw);
            }
        });
    }

    @Override
    public void onSuccess(String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onFail(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

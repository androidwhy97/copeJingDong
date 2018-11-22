package com.bwie.copejingdong;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bwie.copejingdong.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sp = getSharedPreferences("config", MODE_PRIVATE);
        boolean is_login = sp.getBoolean("is_login", false);
        if (is_login) {

        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}

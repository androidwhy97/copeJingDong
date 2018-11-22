package com.bwie.copejingdong;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {

    private TextView text;
    private int sec = 3;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            sec--;
            if (sec>0){
                text.setText(sec+"s");
            }else{
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            handler.sendEmptyMessageDelayed(0,1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        text = findViewById(R.id.timer);
        text.setText(sec+"s");
        handler.sendEmptyMessageDelayed(0,1000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }
}

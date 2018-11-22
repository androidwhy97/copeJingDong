package com.bwie.copejingdong.utils;

import android.os.Handler;
import android.os.Message;

import com.google.common.io.CharStreams;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/9
 */
public class HttpHelpter {
    private static HttpHelpter instance = new HttpHelpter();

    private HttpHelpter() {

    }

    public static HttpHelpter getInstance() {
        return instance;
    }

    public HttpHelpter doGet(String urlPath) {
        doHttp(urlPath);
        return this;
    }

    private void doHttp(final String urlPath) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    URL url = new URL(urlPath);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.connect();

                    int code = connection.getResponseCode();
                    Message message = Message.obtain();
                    if (code == HttpURLConnection.HTTP_OK) {
                        message.what = SUCCESS;
                        String data = CharStreams.toString(new InputStreamReader(connection.getInputStream(), "utf-8"));
                        message.obj = data;
                    }
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private final int SUCCESS = 2000;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            switch (what) {
                case SUCCESS:
                    String data = (String) msg.obj;
                    listener.success(data);
                    break;
            }
        }
    };

    public interface HttpListener {
        void success(String data);
    }

    private HttpListener listener;

    public void result(HttpListener listener) {
        this.listener = listener;
    }
}

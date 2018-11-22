package com.bwie.copejingdong.goodskind;

import android.os.Handler;
import android.os.Message;

import com.bwie.copejingdong.utils.HttpCallBack;
import com.bwie.copejingdong.utils.OkUtils;
import com.bwie.copejingdong.utils.UrlHolder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/20
 */
public class GoodsKindModel {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private static final String TAG = "GoodsKindModel";

    public void getGoodKind(final HttpCallBack httpCallBack) {
        OkUtils.enqueueGet(UrlHolder.LEFT_KIND_URL, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                final String string = body.string();
                if (string != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            httpCallBack.successful(string);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            httpCallBack.failer("出错了");
                        }
                    });
                }
            }
        });
    }

    public void getGoodShow(int position, final HttpCallBack httpCallBack) {
        OkUtils.enqueueGet(UrlHolder.RIGHT_GOODS_URL + position, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ResponseBody body = response.body();
                final String string = body.string();
                if (string != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            httpCallBack.successful(string);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            httpCallBack.failer("出错了");
                        }
                    });
                }
            }
        });
    }
}

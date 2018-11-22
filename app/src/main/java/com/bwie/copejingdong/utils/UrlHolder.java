package com.bwie.copejingdong.utils;

/**
 * 文件描述：
 * 作者：王恒钰
 * 创建时间：2018/11/9
 */
public class UrlHolder {

    private static final String BASE_URL = "http://www.zhaoapi.cn/";
    //登录的url
    public static final String LOGIN_URL = BASE_URL + "user/login";
    //注册的url
    public static final String REGISTER_URL = BASE_URL + "user/reg";
    //左侧接口
    public static final String LEFT_KIND_URL = BASE_URL + "product/getCatagory";
    //右侧接口
    public static final String RIGHT_GOODS_URL = BASE_URL + "product/getProductCatagory?cid=";
}

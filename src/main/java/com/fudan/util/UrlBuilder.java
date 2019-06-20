package com.fudan.util;

public class UrlBuilder {

    public static String urlForAppId(String code){
        return "https://api.weixin.qq.com/sns/jscode2session" +
                "?appid=wxb7b507cdfd48f3af&secret=3a44e3378f6b91a2738ac736f48cb9f2&js_code=" +code+
                "&grant_type=authorization_code";
    }

    public static String urlForToken(){
        return "http://47.102.131.149:80/applet-login";
    }
}
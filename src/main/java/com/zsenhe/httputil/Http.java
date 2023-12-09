package com.zsenhe.httputil;

import com.zsenhe.httputil.request.HttpRequest;

import java.net.MalformedURLException;

public class Http {

    private Http(){
    }

    /**
     * 快速构建http请求
     * @param url
     * @return
     * @throws MalformedURLException
     */
    public static HttpRequest url(String url){
        return new HttpRequest(url);
    }


}

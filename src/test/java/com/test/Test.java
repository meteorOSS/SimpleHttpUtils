package com.test;

import com.zsenhe.httputil.request.HttpRequest;

import java.net.MalformedURLException;

public class Test {

    public static void main(String[] args) {
        try {
            HttpRequest httpRequest = new HttpRequest("https://www.baidu.com{roll}");
            httpRequest.pathParam("roll","");
            httpRequest.queryParam("wd","meteor");
            httpRequest.buildURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}

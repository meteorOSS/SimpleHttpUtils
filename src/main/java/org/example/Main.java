package org.example;

import com.zsenhe.httputil.Http;
import com.zsenhe.httputil.HttpHeaders;
import com.zsenhe.httputil.callback.AsyncHttpResponseCallBack;
import com.zsenhe.httputil.request.HttpRequest;
import com.zsenhe.httputil.request.RequestMethod;
import com.zsenhe.httputil.response.PackHttpResponse;

import java.io.IOException;
import java.net.MalformedURLException;

public class Main {
    public static void main(String[] args) throws Exception {


        PackHttpResponse body = Http.url("https://api.github.com/users/{user}")
                .header(HttpHeaders.USER_AGENT, "user-agent") // 设置请求头字段
                .body("body") // 设置请求体
                .timeOut(10).execute(RequestMethod.POST); // 发起Post请求

        String response = body.getAsString("utf-8");
        System.out.println(response);


        /**
         * 发起 get 请求
         * ( 将代码包裹在 try() 中以自动关闭IO资源 )
         */
        try(PackHttpResponse packHttpResponse = Http.url("https://api.github.com/users/{user}").pathParam("user","meteorOSS").get()){
            System.out.println(packHttpResponse.getAsString("utf-8"));
        }

        /**
         * 异步请求
         * 传入一个 AsyncHttpResponseCallBack 实现类
         * AsyncHttpResponseCallBack 回调函数:
         *  success(PackHttpResponse response) 请求成功
         *  fail(Exception e) 出现错误
         */
         AsyncHttpResponseCallBack asyncHttpResponseCallBack = new AsyncHttpResponseCallBack() {
             @Override
             public void success(PackHttpResponse packHttpResponse) {
                 //...
             }

             @Override
             public void fail(Exception e) {
                //...
             }
         };
         Http.url("https://api.github.com/users/meteorOSS").asyncPost(asyncHttpResponseCallBack);

    }
}

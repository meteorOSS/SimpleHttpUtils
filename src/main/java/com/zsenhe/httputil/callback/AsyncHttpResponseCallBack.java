package com.zsenhe.httputil.callback;

import com.zsenhe.httputil.response.PackHttpResponse;

/**
 * 异步请求回调
 */
public interface AsyncHttpResponseCallBack {

    /**
     * success
     * @param packHttpResponse
     */
    void success(PackHttpResponse packHttpResponse);

    /**
     * fail
     */
    void fail(Exception e);
}

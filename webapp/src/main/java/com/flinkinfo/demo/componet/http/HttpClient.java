package com.flinkinfo.demo.componet.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * 网络请求接口类
 */
public interface HttpClient
{
    /**
     * get请求
     * @param url 请求地址
     * @param headers 请求头
     * @return
     * @throws IOException
     */
    public Response requestByGet(String url, Headers headers) throws IOException;


    /**
     * post请求
     *
     * @param body   请求体
     * @param url    请求内容
     * @param header 请求头 为空时为null
     * @return
     * @throws IOException
     */
    public Response requestByPost(RequestBody body, String url, Headers header) throws IOException;
}

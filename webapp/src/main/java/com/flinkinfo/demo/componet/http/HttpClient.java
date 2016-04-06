package com.flinkinfo.demo.componet.http;

import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Map;

/**
 * 网络请求接口类
 */
public interface HttpClient
{
    /**
     * get请求
     *
     * @param url     请求地址
     * @param headers 请求头
     * @return
     * @throws IOException
     */
    Response requestByGet(String url, Map headers) throws IOException;


    /**
     * post请求
     *
     * @param params   请求体
     * @param url    请求内容
     * @param headers 请求头 为空时为null
     * @return
     * @throws IOException
     */
    Response requestByPost(Map params, String url, Map headers) throws IOException;
}

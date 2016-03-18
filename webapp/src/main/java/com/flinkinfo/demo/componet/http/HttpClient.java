package com.flinkinfo.demo.componet.http;

import com.squareup.okhttp.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 网络访问
 */
@Component
public class HttpClient
{
    private OkHttpClient client = new OkHttpClient();

    /**
     * get请法庭
     * @param url 请求地址
     * @param headers 请求头
     * @return
     * @throws IOException
     */
    public Response requestByGet(String url, Headers headers) throws IOException
    {
        Request request;
        if (headers != null)
        {
            request = new Request.Builder()
                    .url(url)
                    .headers(headers)
                    .build();
        }
        else
        {
            request = new Request.Builder()
                    .url(url)
                    .build();
        }

        return client.newCall(request).execute();
    }

    /**
     * post请求
     *
     * @param body   请求体
     * @param url    请求内容
     * @param header 请求头 为空时为null
     * @return
     * @throws IOException
     */
    public Response requestByPost(RequestBody body, String url, Headers header) throws IOException
    {
        Request request;
        //请求参数设置
        if (header != null)
        {
            request = new Request.Builder()
                    .headers(header)
                    .url(url)
                    .post(body)
                    .build();
        }
        else
        {
            request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
        }
        //发送请求
        Response response = client.newCall(request).execute();
        return response;
    }

}

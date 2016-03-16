package com.flinkinfo.demo.componet.http;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 网络访问
 */
@Component
public class HttpClient
{
    private OkHttpClient client = new OkHttpClient();

    public String post(RequestBody body, String url) throws IOException
    {
        //请求参数设置
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        //发送请求
        Response response = client.newCall(request).execute();

        if (response.isSuccessful())
        {
            return response.body().string();
        }
        else
        {
            throw new IOException("IOException" + response);
        }
    }

    public Response get() throws IOException
    {
        Request request = new Request.Builder()
                .url("http://119.254.106.102:8080/bdrs/query/createImageAction.do?method=getImg&t=Wed Mar 16 2016 18:19:24 GMT+0800 (CST)")
                .build();

        return client.newCall(request).execute();
    }
}

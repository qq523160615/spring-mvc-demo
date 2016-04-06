package com.flinkinfo.demo.componet.http;

import com.squareup.okhttp.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 网络访问
 */
@Component("httpclient.okhttp")
public class OkHttpClientImpl implements HttpClient
{
    private OkHttpClient client = new OkHttpClient();

    /**
     * get请法庭
     *
     * @param url     请求地址
     * @param headers 请求头
     * @return
     * @throws IOException
     */
    public Response requestByGet(String url, Map headers) throws IOException
    {
        Request request;
        if (headers != null)
        {
            request = new Request.Builder()
                    .url(url)
                    .headers(Headers.of(headers))
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
     * @param params 请求体
     * @param url    请求内容
     * @param headers 请求头 为空时为null
     * @return
     * @throws IOException
     */
    public Response requestByPost(Map params, String url, Map headers) throws IOException
    {
        Request request;

        //请求参数设置
        if (headers != null)
        {
            request = new Request.Builder()
                    .headers(Headers.of(headers))
                    .url(url)
                    .post(mapToBody(params))
                    .build();
        }
        else
        {
            request = new Request.Builder()
                    .url(url)
                    .post(mapToBody(params))
                    .build();
        }
        //发送请求
        Response response = client.newCall(request).execute();
        return response;
    }

    private RequestBody mapToBody(Map params)
    {
        FormEncodingBuilder body = new FormEncodingBuilder();

        Set<String> keySet = params.keySet();
        Iterator<String> it = keySet.iterator();

        while (it.hasNext())
        {
            String key = it.next();
            String value = (String) params.get(key);
            body.add(key, value);
        }

        return body.build();
    }
}

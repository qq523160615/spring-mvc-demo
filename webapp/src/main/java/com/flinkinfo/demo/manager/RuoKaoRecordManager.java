package com.flinkinfo.demo.manager;

import com.flinkinfo.demo.componet.http.HttpClient;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 软考成绩查询
 */
@Component
public class RuoKaoRecordManager
{
    @Autowired
    HttpClient httpClient;

    private String record;

    @Value("${ruokao.record_url}")
    String recordUrl;

    @Value("${ruokao.image_code_url}")
    String imageCodeUrl;

    public String getRecord()
    {
        return record;
    }

    /**
     * 请求获取成绩
     * @throws IOException
     */
    public void requestRecord() throws IOException
    {
        Response response = httpClient.requestByPost(requestBody(),recordUrl, recordHeaders());
        this.record = response.toString();
    }


    /**
     * 请求获取验证码
     * @return
     * @throws IOException
     */
    public byte[] requestImageCode() throws IOException
    {
        Response response = httpClient.requestByGet(imageCodeUrl,imageCodeHeaders());
        return response.body().bytes();
    }

    /**
     * 返回请求表单
     *
     * @return
     */
    public RequestBody requestBody()
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("table", "RKCJCX_RKCJCX")
                .add("unitld", "100")
                .add("type", "2")
                .add("columns[0].property", "")
                .add("columns[0].code", "ZKZH")
                .add("columns[0].colType", "varchar2")
                .add("columns[0].operator", "1")
                .add("columns[1].property", "445281199209224619")
                .add("columns[1].code", "ZJH")
                .add("columns[1].colType", "varchar2")
                .add("columns[1].operator", "1")
                .add("columns[2].property", "2015年下半年")
                .add("columns[2].code", "KSSJ")
                .add("columns[2].colType", "varchar2")
                .add("columns[2].operator", "1")
                .add("columns[3].property", "林镇辉")
                .add("columns[3].code", "XM")
                .add("columns[3].colType", "varchar2")
                .add("columns[3].operator", "1")
                .add("verifyData", "1484")
                .build();

        return formBody;
    }

    /**
     * 请求成绩请求头
     * @return
     */
    public Headers recordHeaders()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Host", "119.254.106.102:8080");
        map.put("Connection", "keep-alive");
        map.put("Content-Length", "546");
        map.put("Cache-Control", "max-age=0");
        map.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        map.put("Origin", "http://119.254.106.102:8080");
        map.put("Upgrade-Insecure-Requests", "1");
        map.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36");
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put("Referer", "http://119.254.106.102:8080/bdrs/query/queryAction.do?method=customQuery");
        map.put("Accept-Encoding", "gzip, deflate");
        map.put("Accept-Language", "zh-CN,zh;q=0.8");
        map.put("Cookie", "JSESSIONID=B8CF36570961D6CDF1834356A4E5AFE0");
        Headers headers = Headers.of(map);
        return headers;
    }

    /**
     * 请求验证码请求头
     * @return
     */
    public Headers imageCodeHeaders()
    {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Cookie", "JSESSIONID=B8CF36570961D6CDF1834356A4E5AFE0");
        map.put("Referer", "http://www.ruankao.org.cn/jsjnew/cms/onlineservice/");
        Headers headers = Headers.of(map);
        return headers;
    }
}

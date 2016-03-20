package com.flinkinfo.demo.manager;

import com.flinkinfo.demo.componet.http.HttpClient;
import com.flinkinfo.demo.componet.http.OkHttpClientImpl;
import com.flinkinfo.demo.componet.ocr.OcrCode;
import com.flinkinfo.demo.componet.util.ImageUtil;
import com.flinkinfo.demo.componet.util.JsDate;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier(value = "httpclient.okhttp")
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
    public void requestRecord(String identify,String time,String name) throws IOException
    {
        Response response = httpClient.requestByPost(requestBody(identify,time,name),recordUrl, recordHeaders());
        this.record = response.body().string();
    }


    /**
     * 请求获取验证码
     * @return
     * @throws IOException
     */
    public byte[] requestImageCode() throws IOException
    {
        Response response = httpClient.requestByGet(imageCodeUrl + JsDate.jsDate(),imageCodeHeaders());
        return response.body().bytes();
    }

    /**
     * 返回请求表单
     *
     * @return
     */
    public RequestBody requestBody(String identify,String time,String name) throws IOException
    {
        RequestBody formBody = new FormEncodingBuilder()
                .add("table", "RKCJCX_RKCJCX")
                .add("unitld", "100")
                .add("type", "2")
                .add("columns[0].property","520144903508")
                .add("columns[0].code", "ZKZH")
                .add("columns[0].colType", "varchar2")
                .add("columns[0].operator", "1")
                .add("columns[1].property",identify)
                .add("columns[1].code", "ZJH")
                .add("columns[1].colType", "varchar2")
                .add("columns[1].operator", "1")
                .add("columns[2].property", time)
                .add("columns[2].code", "KSSJ")
                .add("columns[2].colType", "varchar2")
                .add("columns[2].operator", "1")
                .add("columns[3].property", name)
                .add("columns[3].code", "XM")
                .add("columns[3].colType", "varchar2")
                .add("columns[3].operator", "1")
                .add("verifyData", "2442")
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
  //      map.put("Connection", "keep-alive");
  //      map.put("Content-Length", "546");
        map.put("Cache-Control", "max-age=0");
        map.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        map.put("Origin", "http://119.254.106.102:8080");
        map.put("Upgrade-Insecure-Requests", "1");
        map.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36");
        map.put("Content-Type", "application/x-www-form-urlencoded");
        map.put("Referer", "http://119.254.106.102:8080/bdrs/query/queryAction.do?method=customQuery");
        map.put("Accept-Encoding", "gzip, deflate");
        map.put("Accept-Language", "zh-CN,zh;q=0.8");
        map.put("Cookie", "JSESSIONID=67D5C7A6869F6EB564F71431A49A2BAF");
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
        map.put("Cookie", "JSESSIONID=67D5C7A6869F6EB564F71431A49A2BAF");
        map.put("Referer", "http://119.254.106.102:8080/bdrs/query/queryAction.do?method=customQuery");
        map.put("Host","119.254.106.102:8080");
        map.put("Accept","image/webp,image/*,*/*;q=0.8");
        map.put("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36");
        map.put("Accept-Encoding","gzip, deflate, sdch");
        map.put("Accpet-Language","zh-CN,zh;q=0.8");
        Headers headers = Headers.of(map);
        return headers;
    }

    /**
     * 获取图片验证码
     * @return
     * @throws IOException
     */
    public String getImageCodeString() throws IOException
    {
        byte[] imageBytes = requestImageCode();
        ImageUtil.byte2image(imageBytes,"/tmp/data/image.png");
        return OcrCode.vefyCode("/tmp/data/image.png");
    }
}

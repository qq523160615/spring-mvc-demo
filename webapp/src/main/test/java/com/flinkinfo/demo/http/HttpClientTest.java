package com.flinkinfo.demo.http;

import com.flinkinfo.demo.componet.http.HttpClient;

import com.flinkinfo.demo.componet.util.ImageUtil;
import com.squareup.okhttp.Response;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * 网络类测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-servlet-test.xml")
public class HttpClientTest extends TestCase
{
    @Autowired
    HttpClient httpClient;

    @Test
    public void testGet() throws IOException
    {
        Response response = httpClient.get();
        byte[] imageByte = response.body().bytes();
//        new File("Users/jimmy/Desktop/data");
        ImageUtil.byte2image(imageByte,"/tmp/data/image.png");
    }
}

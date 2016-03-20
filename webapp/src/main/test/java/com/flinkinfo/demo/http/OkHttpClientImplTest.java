package com.flinkinfo.demo.http;

import com.flinkinfo.demo.componet.http.OkHttpClientImpl;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 网络类测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-servlet-test.xml")
public class OkHttpClientImplTest extends TestCase
{
    @Autowired
    OkHttpClientImpl okHttpClientImpl;
}

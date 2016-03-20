package com.flinkinfo.demo.util;

import com.flinkinfo.demo.componet.util.JsDate;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 测试生成js Date格式
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-servlet-test.xml")
public class JsDateTest extends TestCase
{
    @Test
    public void testJsDate()
    {
        System.out.print(JsDate.jsDate());
    }
}

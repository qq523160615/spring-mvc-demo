package com.flinkinfo.demo.ocr;

import com.flinkinfo.demo.componet.ocr.OcrCode;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 验证码识别测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-servlet-test.xml")
public class OcrTest extends TestCase
{
    @Autowired
    OcrCode ocrCode;

    @Test
    public void testVefyCode()
    {
        String code = ocrCode.vefyCode("/tmp/data/image.gif");
        System.out.println(code);
    }
}

package com.flinkinfo.demo.manager;

import com.flinkinfo.demo.componet.util.ImageUtil;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * 软考成绩查询
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-servlet-test.xml")
public class RuoKaoRecordManagerTest extends TestCase
{
    @Autowired
    RuoKaoRecordManager ruoKaoRecordManager;

    /**
     * 测试获得成绩
     * @throws IOException
     */
    @Test
    public void testRequestRecord() throws IOException
    {
        ruoKaoRecordManager.requestRecord("445281199209224619","2015年下半年","林镇辉");
        System.out.println(ruoKaoRecordManager.getRecord());
    }

    /**
     * 测试获得验证码
     * @throws IOException
     */
    @Test
    public void testRequestImageCode() throws IOException
    {
        byte[] imageBytes = ruoKaoRecordManager.requestImageCode();
        ImageUtil.byte2image(imageBytes,"/tmp/data/image.png");
    }


    /**
     * 测试获得图片验证码字符串
     */
    @Test
    public void testGetImageCodeString() throws IOException
    {
        System.out.print(ruoKaoRecordManager.getImageCodeString());
    }
}

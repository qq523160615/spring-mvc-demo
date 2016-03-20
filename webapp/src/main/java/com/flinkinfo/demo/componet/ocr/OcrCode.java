package com.flinkinfo.demo.componet.ocr;

import com.asprise.ocr.Ocr;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Ocr验证码识别
 */
public class OcrCode
{
    public static String vefyCode(String url)
    {
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
        String s = ocr.recognize(new File[] {new File(url)}, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
        char[] chars = s.toCharArray();
        s = "";
        for (char c : chars)
        {
            if(c == '*')
            {
                c = '0';
            }
            s = s + c;
        }
        ocr.stopEngine();
        return s;
    }
}

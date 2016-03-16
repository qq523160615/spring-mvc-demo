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
@Component
public class OcrCode
{
    public String vefyCode(String url)
    {
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
        String s = ocr.recognize(new File[] {new File(url)}, Ocr.RECOGNIZE_TYPE_TEXT, Ocr.OUTPUT_FORMAT_PLAINTEXT);
        System.out.println("Result: " + s);
        ocr.stopEngine();
        return s;
    }
}

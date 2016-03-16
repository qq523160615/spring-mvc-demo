package com.flinkinfo.demo.componet.util;

import javax.imageio.stream.FileImageOutputStream;
import java.io.File;

/**
 * 图片解斩
 */
public class ImageUtil
{
    public static void byte2image(byte[] data, String path)
    {
        if (data.length < 3 || path.equals("")) return;
        try
        {
            File file = new File(path);
            FileImageOutputStream imageOutput = new FileImageOutputStream(file);
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        }
        catch (Exception ex)
        {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }
}

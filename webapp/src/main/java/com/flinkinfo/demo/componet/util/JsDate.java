package com.flinkinfo.demo.componet.util;

import java.util.Date;

/**
 * 生成js Date格式
 */
public class JsDate
{
    public static String jsDate()
    {
        String date = new Date().toString();
        String[] time = date.split(" ");
        return time[0] + " " + time[1] + " "
                + time[2] + " " + time[5] + " "
                + time[3] + " GMT+0800 (" + time[4] + ")";
    }
}

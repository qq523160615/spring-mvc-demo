package com.flinkinfo.demo;

import freemarker.template.SimpleNumber;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

import java.util.List;

public class IndexOfMethod implements TemplateMethodModel
{

    public TemplateModel exec(List args) throws TemplateModelException
    {
//        if (args.size() != 2)
//        {
//            return new TemplateString("aldflakdlfalds");
//        }
//        return new SimpleNumber(
//                ((String) args.get(1)).indexOf((String) args.get(0)));
        String sum = "";
        for (Object string : args)
        {
            sum = sum + "," + string;
        }

        return new TemplateString(sum + "," + "aaaa");
    }
}

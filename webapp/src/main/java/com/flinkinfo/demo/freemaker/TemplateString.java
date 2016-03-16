package com.flinkinfo.demo.freemaker;

import freemarker.template.TemplateModelException;
import freemarker.template.TemplateScalarModel;

/**
 * Created by jimmy on 16/3/12.
 */
public class TemplateString implements TemplateScalarModel
{
    private String sring;

    public TemplateString(String string)
    {
        this.sring = string;
    }

    public String getAsString() throws TemplateModelException
    {
        return this.sring;
    }
}

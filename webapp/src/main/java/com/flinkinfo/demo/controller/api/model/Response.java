package com.flinkinfo.demo.controller.api.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Map;

/**
 * Response
 *
 * @author kutzhang@gmail.com
 */
public class Response implements Serializable
{
    // 成功状态
    public static final int STATUS_SUCCESS = 0;

    // 失败状态
    public static final int STATUS_FAILURE = 1;

    // 应答状态
    @JSONField(name = "status")
    private int status;

    // 错误消息，如无错，则为nil
    @JSONField(name = "error_message")
    private String errorMessage;

    // 应答内容
    @JSONField(name = "content")
    private Map<String, Object> content;

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public Map<String, Object> getContent()
    {
        return content;
    }

    public void setContent(Map<String, Object> content)
    {
        this.content = content;
    }
}
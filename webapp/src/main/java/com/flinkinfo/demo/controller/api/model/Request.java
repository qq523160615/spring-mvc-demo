package com.flinkinfo.demo.controller.api.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Map;

/**
 * Request
 *
 * @author kutzhang@gmail.com
 */
public class Request implements Serializable
{
    // 操作系统
    @JSONField(name = "os")
    private String os;

    // 操作系统版本
    @JSONField(name = "os_version")
    private String osVersion;

    // 应用名
    @JSONField(name = "app_name")
    private String appName;

    // 应用版本
    @JSONField(name = "app_version")
    private String appVersion;

    // UDID
    @JSONField(name = "udid")
    private String udid;

    // 服务名
    @JSONField(name = "service_name")
    private String serviceName;

    // 参数
    @JSONField(name = "params")
    private Map<String, Object> params;

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    public String getOsVersion()
    {
        return osVersion;
    }

    public void setOsVersion(String osVersion)
    {
        this.osVersion = osVersion;
    }

    public String getAppName()
    {
        return appName;
    }

    public void setAppName(String appName)
    {
        this.appName = appName;
    }

    public String getAppVersion()
    {
        return appVersion;
    }

    public void setAppVersion(String appVersion)
    {
        this.appVersion = appVersion;
    }

    public String getUdid()
    {
        return udid;
    }

    public void setUdid(String udid)
    {
        this.udid = udid;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public Map<String, Object> getParams()
    {
        return params;
    }

    public void setParams(Map<String, Object> params)
    {
        this.params = params;
    }
}
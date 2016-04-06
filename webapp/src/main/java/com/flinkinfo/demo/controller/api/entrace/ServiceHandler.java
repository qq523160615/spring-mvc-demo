package com.flinkinfo.demo.controller.api.entrace;

import com.flinkinfo.demo.controller.api.model.Request;
import com.flinkinfo.demo.controller.api.model.Response;

/**
 * 服务处理器
 *
 * @author kutzhang@gmail.com
 */
public interface ServiceHandler
{
    String supportServiceName();

    Response handle(Request request) throws Exception;
}

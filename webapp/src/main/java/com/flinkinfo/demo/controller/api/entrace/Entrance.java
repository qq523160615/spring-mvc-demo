package com.flinkinfo.demo.controller.api.entrace;

import com.flinkinfo.demo.controller.api.model.Request;
import com.flinkinfo.demo.controller.api.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 入口
 *
 * @author jimmy
 */
@Controller
public class Entrance
{
    @Autowired
    private List<ServiceHandler> handlers;

    private Map<String, ServiceHandler> mapping;

    @PostConstruct
    public void init()
    {
        mapping = new HashMap<String, ServiceHandler>();
        for (ServiceHandler handler : handlers)
        {
            mapping.put(handler.supportServiceName(), handler);
        }
    }

    @ResponseBody
    @RequestMapping(
            value = "/api",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public Response handle(@RequestBody Request request) throws Exception
    {
        ServiceHandler handler = mapping.get(request.getServiceName());
        if (handler == null)
        {
            throw new Exception("404");
        }

        return handler.handle(request);
    }
}

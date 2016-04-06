package com.flinkinfo.demo.controller.api.service;


import com.flinkinfo.demo.controller.api.entrace.ServiceHandler;
import com.flinkinfo.demo.controller.api.model.Request;
import com.flinkinfo.demo.controller.api.model.Response;
import com.flinkinfo.demo.controller.api.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Component
public class DemoService implements ServiceHandler
{
    @Override
    public String supportServiceName()
    {
        return "demo";
    }

    @Override
    public Response handle(Request request) throws Exception
    {
        User user = new User("kut", 100, new ArrayList<String>()
        {
            {
                add("shosldll");
                add("lsllslsslslsl");
            }
        });

        final List<User> users = new ArrayList<User>();
        users.add(user);

        user = new User("kut", 100, new ArrayList<String>()
        {
            {
                add("shosldll");
                add("lsllslsslslsl");
            }
        });
        users.add(user);


        Response response = new Response();
        response.setStatus(Response.STATUS_SUCCESS);
        response.setContent(new HashMap<String, Object>()
        {
            {
                put("users", users);
                put("message", "show me the money");
            }
        });
        return response;
    }
}

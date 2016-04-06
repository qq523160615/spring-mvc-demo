package com.flinkinfo.demo.controller.api.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable
{
    @JSONField(name = "name")
    private String name;

    @JSONField(name = "age")
    private int age;

    @JSONField(name = "show_messages")
    List<String> messages;

    public User(String name, int age, List<String> messages)
    {
        this.name = name;
        this.age = age;
        this.messages = messages;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public List<String> getMessages()
    {
        return messages;
    }
}

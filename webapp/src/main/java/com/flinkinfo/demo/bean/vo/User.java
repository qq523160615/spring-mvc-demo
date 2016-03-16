package com.flinkinfo.demo.bean.vo;

import com.flinkinfo.demo.annotation.Between;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User
{
    @NotNull(message = "用户名不能为空")
    private String username;

    @Pattern(regexp = "[0-9a-zA-Z_](6,30)",message = "密码必须是6-30个字母数字")
    private String password;

    @Length(min = 2,max = 10,message = "真实姓名长度2-10之间")
    private String realName;

    @Between(min = 18,max = 45)
    private int age;

    @Email(message = "邮件格式不正确")
    private String email;

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRealname()
    {
        return realName;
    }

    public void setRealname(String realname)
    {
        this.realName = realname;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}

package com.flinkinfo.demo.controller;

import com.flinkinfo.demo.bean.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OtherController
{
    @RequestMapping(value = "/otherWolcome")
    public ModelAndView getFirstPage(HttpServletRequest request)
    {
        System.out.print("otherWolcome");
        ModelAndView mv = new ModelAndView("welcome");
        List<User> users = new ArrayList<User>();
        for(int i =0; i < 10;i++)
        {
            User user = new User();
            users.add(user);
        }
        mv.addObject("users",users);
        return mv;
    }
}

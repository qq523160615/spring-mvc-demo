package com.flinkinfo.demo.controller.demo;

import com.flinkinfo.demo.bean.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class SpringMvcController
{
    @RequestMapping(value = "/welcome")
    public String getFirstPage(HttpServletRequest request)
    {
        System.out.println(request.getHeader("Referer"));
        if (request.getHeader("Referer") != null && request.getHeader("Referer").equals("http://localhost:8080/index"))
        {
            return "register";
        }
        else
        {
            return "registersuccess";
        }
    }

    @RequestMapping(value = "/welcome2/{name}/{age}", method = RequestMethod.GET)
    public String printWelocme(ModelMap modelMap, @PathVariable("name") String name, @PathVariable("age") int age)
    {
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("age", age);
        return "welcome2";
    }

    @RequestMapping(value = "result", method = RequestMethod.POST)
    public String result(ModelMap modelMap, @RequestParam String name, @RequestParam int age)
    {
        modelMap.addAttribute("name", name);
        modelMap.addAttribute("age", age);
        return "result";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String addUser(ModelMap modelMap)
    {
        return "add_user";
    }


    @RequestMapping("/register")
    public String register()
    {
        return "register";
    }

    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public String doRegister(@Valid User user, BindingResult result, ModelMap modelMap)
    {
        if (result.hasErrors())
        {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors)
            {
                modelMap.addAttribute("ERR_" + fieldError.getField(), fieldError.getDefaultMessage());
            }
            return "register";
        }

        return "registersuccess";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index()
    {
        return "index";
    }

    @CrossOrigin
    @RequestMapping(value = "/postJson", method = RequestMethod.POST)
    @ResponseBody
    public String postJson(@RequestBody String json)
    {
        return json;
    }

    @RequestMapping("/getJson")
    @ResponseBody
    public String getJson()
    {
        return "{\"name\":\"jimmy\",\"age\":12}";
    }

    @RequestMapping("/crossOrigin")
    public String crossOrigin()
    {
        return "cross_origin";
    }
}

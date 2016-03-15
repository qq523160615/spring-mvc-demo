package com.flinkinfo.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class SpringMvcController
{
    @RequestMapping(value = "/welcome")
    public ModelAndView getFirstPage(HttpServletRequest request)
    {
//        String name = request.getParameter("name");
//        System.out.print(name);
//        ModelAndView mv = new ModelAndView("welcome");
//        mv.addObject("name",name);
        return new ModelAndView("redirect:/otherWolcome");
    }

    @RequestMapping(value = "/welcome2/{name}/{age}",method = RequestMethod.GET)
    public String printWelocme(ModelMap modelMap, @PathVariable("name") String name, @PathVariable("age") int age)
    {
        modelMap.addAttribute("name",name);
        modelMap.addAttribute("age",age);
        return "welcome2";
    }

    @RequestMapping(value = "result",method = RequestMethod.POST)
    public String result(ModelMap modelMap, @RequestParam String name,@RequestParam int age)
    {
        modelMap.addAttribute("name",name);
        modelMap.addAttribute("age",age);
        return "result";
    }

    @RequestMapping(value = "/adduser",method = RequestMethod.GET)
    public String addUser(ModelMap modelMap)
    {
        return "add_user";
    }


    @RequestMapping("/register")
    public String register()
    {
        return "register";
    }

    @RequestMapping(value = "/doRegister",method = RequestMethod.POST)
    public String doRegister(@Valid User user, BindingResult result, ModelMap modelMap)
    {
        if(result.hasErrors())
        {
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors)
            {
                modelMap.addAttribute("ERR_" + fieldError.getField(),fieldError.getDefaultMessage());
            }
            return "/register";
        }

        return "registersuccess";
    }
}

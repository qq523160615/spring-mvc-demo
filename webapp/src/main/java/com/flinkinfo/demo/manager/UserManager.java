package com.flinkinfo.demo.manager;

import com.flinkinfo.demo.bean.po.User;
import com.flinkinfo.demo.repository.UserRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component(value = "userManager")
public class UserManager
{
    @Autowired
    UserRepsitory userRepsitory;

    public void save(User user)
    {
        userRepsitory.save(user);
    }

    public User findOneByName(String name)
    {
        return userRepsitory.findOneByName(name);
    }

    public void updateAge(String name, Integer age)
    {
        userRepsitory.updateUser(name, age);
    }


    public void deleteByName(String name)
    {
        userRepsitory.deleteUser(name);
    }

    public List<User> findByNameEndsWith(String name)
    {
        return userRepsitory.findByNameEndsWith(name);
    }

//    public Page<User> findAll()
//    {
//        return userRepsitory.findAll(new PageRequest(5,10));
//    }

    public Page<User> getUser(Integer pageNumber)
    {
        PageRequest request = new PageRequest(pageNumber - 1, 10,new Sort(new Sort.Order(Sort.Direction.DESC,"age")));
        return userRepsitory.findAll(request);
    }

    public List<User> findByDepartmentName(String name)
    {
        return userRepsitory.findByDepartmentName(name);
    }
}

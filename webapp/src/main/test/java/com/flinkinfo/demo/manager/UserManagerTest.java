package com.flinkinfo.demo.manager;

import com.flinkinfo.demo.bean.po.Department;
import com.flinkinfo.demo.bean.po.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用户管理测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-servlet-test.xml")
public class UserManagerTest extends TestCase
{
    @Autowired
    private UserManager userManager;

    @Autowired
    private DepartmentRepositoryManager departmentRepositoryManager;

    @Test
    public void testSaveSucceed()
    {
        Department department = new Department();
        department.setName("技术部");
        departmentRepositoryManager.save(department);

        User user = new User();
        user.setName("jimmy");
        user.setPhone("15902078327");
        user.setAppName("app");
        user.setAge(25);
        user.setDepartment(department);

        userManager.save(user);
    }
}

package com.flinkinfo.demo.manager;

import com.flinkinfo.demo.bean.po.Department;
import com.flinkinfo.demo.bean.po.User;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

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

    /**
     * 测试保存成功
     */
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

    /**
     * 测试根据名字查找
     */
    @Test
    public void testFindOneByName()
    {
        User user = userManager.findOneByName("jimmy");
        assertNotNull(user);
    }

    /**
     * 测试更新年龄
     */
    @Test
    public void testUpdateAge()
    {
        userManager.updateAge("111", 15);
    }

    /**
     * 测试根据名字删除
     */
    @Test
    public void testDeleteByName()
    {
        userManager.deleteByName("jimmy");
    }

    /**
     * 测试以名字以该字符串结尾的用户
     */
    @Test
    public void testFindByNameEndsWith()
    {
        List<User> userList = userManager.findByNameEndsWith("y");
        assertNotNull(userList);
    }

    /**
     * 测试获得分页
     */
    @Test
    public void testGetUser()
    {
        Page<User> userPage = userManager.getUser(1);
        assertNotNull(userPage);
    }

    /**
     * 测试根据部门名称返回用户列表 SQL语句有问题
     */
    @Test
    public void testFindByDepartmentName()
    {
        List<User> userList = userManager.findByDepartmentName("技术部");
        assertNotNull(userList);
    }
}

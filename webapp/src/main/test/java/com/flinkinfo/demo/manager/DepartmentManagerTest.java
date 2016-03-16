package com.flinkinfo.demo.manager;

import com.flinkinfo.demo.bean.po.Department;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 部门manager测试类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springmvc-servlet-test.xml")
public class DepartmentManagerTest extends TestCase
{
    @Autowired
    DepartmentRepositoryManager departmentRepositoryManager;

    /**
     * 测试保存成功
     */
    @Test
    public void testSave()
    {
        Department department = new Department();
        department.setName("技术部");

        departmentRepositoryManager.save(department);
    }

    /**
     * 测试查找全部
     */
    @Test
    public void testFindAll()
    {
        List<Department> departmentList = departmentRepositoryManager.findAll();
        assertNotNull(departmentList);
    }
}

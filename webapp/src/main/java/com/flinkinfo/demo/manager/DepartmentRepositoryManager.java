package com.flinkinfo.demo.manager;

import com.flinkinfo.demo.bean.po.Department;
import com.flinkinfo.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("depModelRepositoryManager")
public class DepartmentRepositoryManager
{
    @Autowired
    DepartmentRepository departmentRepository;

    public void save(Department department)
    {
        departmentRepository.save(department);
    }

    public List<Department> findAll()
    {
        return departmentRepository.findAll();

    }

}

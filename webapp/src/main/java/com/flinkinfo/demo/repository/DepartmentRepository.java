package com.flinkinfo.demo.repository;


import com.flinkinfo.demo.bean.po.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String>
{

}

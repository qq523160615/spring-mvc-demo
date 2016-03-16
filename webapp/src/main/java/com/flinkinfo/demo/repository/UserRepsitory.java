package com.flinkinfo.demo.repository;

import com.flinkinfo.demo.bean.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepsitory extends JpaRepository<User, String>
{
//    @Query(value="select o from User o where o.name")
//    public User find(String name);

    @Query("select a from User a WHERE a.name =?1")
    public User findOneByName(String name);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update User user set user.age = ?2 where user.name = ?1")
    void updateUser(String name, Integer age);

    @Transactional
    @Modifying
    @Query("delete from User user where user.name=?1")
    void deleteUser(String name);

    @Query(value = "select user from User user where user.name like %?1")
    public List<User> findByNameEndsWith(String name);

    @Query(value = "select user from User user where department = " +
            "(select department from Department department where department.name = ?1)")
    public List<User> findByDepartmentName(String name);
}

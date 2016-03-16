package com.flinkinfo.demo.bean.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tbl_dep")
public class Department
{
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String name;

    @OneToMany(mappedBy = "department",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private Set<User> users;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setUsers(Set<User> users)
    {
        this.users = users;
    }

    public Set<User> getUsers()
    {
        return users;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}

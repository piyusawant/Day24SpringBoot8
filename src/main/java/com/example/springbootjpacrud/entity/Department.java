package com.example.springbootjpacrud.entity;

import jakarta.persistence.*;
import com.example.springbootjpacrud.entity.Department;
import java.util.List;

@Entity
public class Department
{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Student> students;

    public Department(){

    }

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

package com.example.springbootjpacrud.entity;

import jakarta.persistence.*;

import javax.security.auth.Subject;
import java.util.List;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private double marks;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dept_id")
    private Department department;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "student_subject", joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subjects> subjects;

    public Student()
    {

    }

    //getter and Setter

    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getMarks()
    {
        return marks;
    }
    public void setMarks(double marks)
    {
        this.marks = marks;
    }
    public Profile profile()
    {
        return profile;
    }
    public void setProfile(Profile profile)
    {
        this.profile = profile;
    }
    public Department getDepartment()
    {
        return department;
    }
    public void setDepartment(Department department)
    {
        this.department = department;
    }
    public List<Subjects> getSubjects()
    {
        return subjects;
    }
    public void setSubjects(List<Subjects> subjects)
    {
        this.subjects = subjects;
    }

}

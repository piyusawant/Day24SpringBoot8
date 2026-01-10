package com.example.springbootjpacrud.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_name", nullable = false)
    private String name;

    private int marks;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(
            mappedBy = "student",
            cascade = CascadeType.ALL)
   @JsonManagedReference
    private List<Address> addresses = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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
    public int getMarks()
    {
        return marks;
    }
    public void setMarks(int marks)
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
    public List<Address> getAddresses()
    {
        return addresses;
    }
    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
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

package com.example.springbootjpacrud.controller;

import com.example.springbootjpacrud.entity.Student;
import com.example.springbootjpacrud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student create(@RequestBody Student student)
    {
        return studentService.save(student);
    }

    @GetMapping
    public List<Student> getAll()
    {
        return studentService.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
    {
        studentService.delete(id);
    }



}

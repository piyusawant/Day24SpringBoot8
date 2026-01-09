package com.example.springbootjpacrud.controller;

import com.example.springbootjpacrud.entity.Student;
import com.example.springbootjpacrud.entity.dto.StudentDTO;
import com.example.springbootjpacrud.jdbc.StudentJdbcDao;
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

    @Autowired
    private StudentJdbcDao jdbcDao;

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

    //JDBC
    public String saveJdbc(@RequestBody StudentDTO dto)
    {
        jdbcDao.save(dto);
        return "Saved Using JDBCTemplate";
    }


}

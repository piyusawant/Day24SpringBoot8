package com.example.springbootjpacrud.controller;

import com.example.springbootjpacrud.entity.Address;
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
        if(student.getAddresses() != null)
        {
            for(Address address : student.getAddresses()) {
                address.setStudent(student);
            }
        }
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
    @PostMapping("/jdbc/save")
    public String saveJdbc(@RequestBody StudentDTO dto)
    {
        int rows = jdbcDao.saveJdbc(dto);
        return rows > 0 ? "Student saved Using JDBC Template" : "Failed to save data";
    }
    @GetMapping("jdbc/all")
    public List<StudentDTO> findAllJdbc()
    {
        return jdbcDao.findAllJdbc();
    }



}
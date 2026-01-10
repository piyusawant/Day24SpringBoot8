package com.example.springbootjpacrud.service;

import com.example.springbootjpacrud.entity.Student;
import com.example.springbootjpacrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService
{
    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student)
    {
        return studentRepository.save(student);
    }
    public List<Student> getAll()
    {
        return studentRepository.findWithAddresses();
    }
    public void delete(Long id)
    {
        studentRepository.deleteById(id);
    }

}

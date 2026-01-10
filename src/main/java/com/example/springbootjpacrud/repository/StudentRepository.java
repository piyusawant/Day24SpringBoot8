package com.example.springbootjpacrud.repository;

import com.example.springbootjpacrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Long>
{
    @Query("SELECT DISTINCT s FROM Student s LEFT JOIN FETCH s.addresses")
    List<Student> findWithAddresses();

}

package com.example.springbootjpacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootjpacrud.entity.Subjects;


public interface SubjectRepository extends JpaRepository<Subjects, Long>
{
}

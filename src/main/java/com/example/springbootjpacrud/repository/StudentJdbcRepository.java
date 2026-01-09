package com.example.springbootjpacrud.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class StudentJdbcRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(Long id, String name, double marks)
    {
        return jdbcTemplate.update("INSERT INTO student(id, student_name, marks) VALUES (?,?,?)",id,name,marks);
    }

    public List<Map<String, Object>> findAll()
    {
        return jdbcTemplate.queryForList("SELECT * FROM student");
    }

    public int update(Long id, String name)
    {
        return jdbcTemplate.update("UPDATE student SET student_namee=? WHERE id=?", name,id);
    }

    public int delete(Long id)
    {
        return jdbcTemplate.update("DELETE  FROM student WHERE id=?",id);
    }
}

package com.example.springbootjpacrud.jdbc;

import com.example.springbootjpacrud.entity.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentJdbcDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(StudentDTO dto)
    {
        String sql = "INSERT INTO student(name,marks) VALUES(?,?)";
        return jdbcTemplate.update(sql, dto.getName(), dto.getMarks());
    }

    public List<StudentDTO> findAll()
    {
        return jdbcTemplate.query("SELECT name, marks FROM student",
                (rs, rowNum) -> {
            StudentDTO s = new StudentDTO();
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));
            return s;
                });
    }

}

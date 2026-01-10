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

    public int saveJdbc(StudentDTO dto)
    {
        String sql = "INSERT INTO student(student_name, marks) VALUES(?,?)";
        return jdbcTemplate.update(sql, dto.getName(), dto.getMarks());
    }

    public List<StudentDTO> findAllJdbc()
    {
        return jdbcTemplate.query("SELECT student_name, marks FROM student",
                (rs, rowNum) -> {
            StudentDTO s = new StudentDTO();
            s.setName(rs.getString("student_name"));
            s.setMarks(rs.getInt("marks"));
            return s;
                });
    }

}

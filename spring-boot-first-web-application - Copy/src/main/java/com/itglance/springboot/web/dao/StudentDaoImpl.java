package com.itglance.springboot.web.dao;

import com.itglance.springboot.web.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> showList() {
        String sql = "SELECT * FROM student;";
        return jdbcTemplate.query(sql, new RowMapper<Student>() {
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setAddress(resultSet.getString("address"));
                student.setEmail(resultSet.getString("email"));
                return student;
            }
        });

    }

    @Override
    public void addStudent(Student student) {
        String sql="insert into student (name,address,email) values(?,?,?)";
       jdbcTemplate.update(sql,new Object[]{student.getName(),student.getAddress(),student.getEmail()});
    }

    public void deleteStudent(int id) {
        String sql="Delete from student where id=?";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateStudent(Student student) {
        String name=student.getName();
        String address=student.getAddress();
        String email=student.getEmail();
        String updateQuery = "UPDATE student SET name = ?,address=? ,email=? WHERE id = ?";
        jdbcTemplate.update(updateQuery, name, address, email, student.getId());

    }

    public Student getStudentById(int id) {
        for(Student student:showList()){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }
}

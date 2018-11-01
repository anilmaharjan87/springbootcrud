package com.itglance.springboot.web.dao;

import com.itglance.springboot.web.model.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> showList();
    public void addStudent(Student student);
    public void deleteStudent(int id);
    public void updateStudent(Student student);
}

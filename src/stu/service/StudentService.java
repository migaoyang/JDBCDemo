package stu.service;

import stu.domain.PageBean;
import stu.domain.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * 学生处理规则
 */

public interface StudentService {

    List<Student> findAll() throws SQLException;

    void insert(Student student) throws SQLException;

    void delete(int sid) throws SQLException;
    Student findById(int sid) throws SQLException;
    void update(Student student) throws SQLException;

    List<Student> searchStudent(String sname, String sgender)  throws SQLException;


    PageBean<Student> findPageStudent(int currentPage) throws SQLException;


}

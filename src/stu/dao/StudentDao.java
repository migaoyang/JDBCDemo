package stu.dao;

import stu.domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> findAll() throws SQLException;

    void insert(Student student) throws SQLException;

    void delete(int sid) throws SQLException;

    Student findById(int sid)  throws SQLException;

    void update(Student student) throws SQLException;

    List<Student> searchStudent(String sname, String sgender) throws SQLException;

    int findCount()throws SQLException ;

    List<Student> findPageStudent(int page) throws SQLException;

}

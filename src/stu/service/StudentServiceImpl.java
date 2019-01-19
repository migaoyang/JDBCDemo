package stu.service;

import stu.dao.StudentDao;
import stu.dao.StudentDaoImpl;
import stu.domain.PageBean;
import stu.domain.Student;
import util.Constant;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public List<Student> findAll() throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.findAll();
    }

    @Override
    public void insert(Student student) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.insert(student);
    }

    @Override
    public void delete(int sid) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.delete(sid);
    }

    @Override
    public Student findById(int sid) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.findById(sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.update(student);

    }

    @Override
    public List<Student> searchStudent(String sname, String sgender) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        return dao.searchStudent(sname , sgender);

    }

    @Override
    public PageBean<Student> findPageStudent(int currentPage) throws SQLException {

        StudentDao studentDao = new StudentDaoImpl();

        PageBean<Student> studentPageBean = new PageBean<>();
        studentPageBean.setCurrentPage(currentPage);
        studentPageBean.setPageSize(Constant.pageNumber);
        int totalSize = studentDao.findCount();
        studentPageBean.setTotalSize( totalSize );
        studentPageBean.setTotalPage(totalSize % Constant.pageNumber == 0 ? totalSize / Constant.pageNumber : (totalSize % Constant.pageNumber));
        studentPageBean.setList(studentDao.findPageStudent(currentPage));


        return studentPageBean;
    }
}

package stu.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import stu.domain.Student;
import util.Constant;
import util.JDBCUtil02;

import javax.lang.model.element.QualifiedNameable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    /**
     * 查询所有学生
     * @return
     */
    @Override
    public List<Student> findAll() throws SQLException {

        Connection conn = null;
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from stu";
        return  runner.query(sql,new BeanListHandler<Student>(Student.class));
    }

    @Override
    public void insert(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        runner.update("insert into stu values(null, ?, ?, ?, ?, ?, ?)",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo()
                );

    }

    @Override
    public void delete(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "delete from stu where sid= ?";
        runner.update(sql,sid);

    }

    @Override
    public Student findById(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from stu where sid = ?";
        return (Student) runner.query(sql, new BeanHandler<Student>(Student.class),sid);

    }

    @Override
    public void update(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());

        runner.update("update stu set sname = ?,gender = ?, phone = ? , birthday = ? , hobby = ? , info = ?  where sid = ? ",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo(),
                student.getSid()
        );

    }

    @Override
    public List<Student> searchStudent(String sname, String sgender) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());

        String sql = "select * from stu where 1=1 ";
        List<String> list = new ArrayList<String>();
        if ( !(sname == null || "".equals(sname)) ){
            sql = sql+"and sname like  ? ";
            list.add("%" + sname + "%");

        }
        if ( !(sgender == null || sgender.equals("")) ){
            sql = sql + " and gender = ? ";
            list.add(sgender);
        }
        System.out.println(sql);
        return (List<Student>) queryRunner.query(sql, new BeanListHandler<Student>(Student.class),list.toArray());
    }

    @Override
    public int findCount() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select count(*) from stu";
        Long  result = (Long) queryRunner.query("SELECT COUNT(*) FROM stu" , new ScalarHandler() );
        return result.intValue();
    }

    @Override
    public List<Student> findPageStudent(int currentPage) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());

        String sql = "select * from stu limit ? offset ?";

        return queryRunner.query(sql, new BeanListHandler<Student>(Student.class), Constant.pageNumber,(currentPage-1)* Constant.pageNumber);

    }
}

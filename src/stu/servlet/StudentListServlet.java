package stu.servlet;

import stu.dao.StudentDao;
import stu.dao.StudentDaoImpl;
import stu.domain.Student;
import stu.service.StudentService;
import stu.service.StudentServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StudentListServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    doGet(request ,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {


        List<Student> list = null;
        try {
            StudentService dao = new StudentServiceImpl();
            list = dao.findAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list",list);

        //跳转页面
        request.getRequestDispatcher("list.jsp").forward(request,response);


    }
}

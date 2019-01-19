package stu.servlet;

import stu.domain.Student;
import stu.service.StudentService;
import stu.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchStudentServlet")
public class SearchStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            String sname = request.getParameter("sname");

            String sgender = request.getParameter("sgender");
            System.out.println("sname: " + sname  +  "   sgender :  " + sgender);
            StudentService studentService = new StudentServiceImpl();

            ArrayList<Student> list = new ArrayList<>();
            list = (ArrayList<Student>)studentService.searchStudent(sname,sgender);

            request.setAttribute("list", list);
            request.getRequestDispatcher("list.jsp").forward(request, response);



        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

    }
}

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

@WebServlet(name = "EditServlet")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response );

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int sid = Integer.parseInt(request.getParameter("sid"));

            StudentService studentService = new StudentServiceImpl();
            Student student = new Student();
            student = studentService.findById(sid);
            System.out.println(student.toString());

            request.setAttribute("student", student);
            request.getRequestDispatcher("edit.jsp").forward(request,response );

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

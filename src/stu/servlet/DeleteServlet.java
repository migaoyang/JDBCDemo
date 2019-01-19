package stu.servlet;

import stu.service.StudentService;
import stu.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sid = Integer.parseInt(request.getParameter("sid"));

        StudentService studentService = new StudentServiceImpl();
        try {
            studentService.delete(sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        request.getRequestDispatcher("StudentListServlet").forward(request, response);

    }
}

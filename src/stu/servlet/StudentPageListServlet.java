package stu.servlet;

import stu.domain.PageBean;
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

@WebServlet(name = "StudentPageListServlet")
public class StudentPageListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int currentPage ;
            if(request.getParameter("currentPage") == null){
                currentPage = 1;

            }else{
                currentPage= Integer.parseInt(request.getParameter("currentPage"));
            }

            StudentService studentService = new StudentServiceImpl();
            PageBean<Student> studentPageBean= studentService.findPageStudent(currentPage);
            System.out.println(studentPageBean.toString());
            for (Student s:studentPageBean.getList()){
                System.out.println( s.toString() );
            }

            request.setAttribute("studentPageBean", studentPageBean);

            request.getRequestDispatcher("listPageBeanStudent.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }

    }
}

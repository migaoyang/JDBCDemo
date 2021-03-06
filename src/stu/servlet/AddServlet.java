package stu.servlet;

import stu.domain.Student;
import stu.service.StudentService;
import stu.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String birthday = request.getParameter("birthday");
            String info = request.getParameter("info");

            //getParanmeterValues 只能去到一个值
            String []h = request.getParameterValues("hobby");

            String hobby = Arrays.toString(h);
            hobby = hobby.substring(1,hobby.length()-1 );



            //添加到数据库
            Date date = new SimpleDateFormat("yyy-MM-dd").parse(birthday);
            Student student = new Student(gender,phone,hobby,info,date,name);
            System.out.println(student.toString());


            StudentService service = new StudentServiceImpl();
            service.insert(student);

            //跳转页面
            request.getRequestDispatcher("StudentListServlet").forward(request, response);
            System.out.println("tiaozhuan");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}

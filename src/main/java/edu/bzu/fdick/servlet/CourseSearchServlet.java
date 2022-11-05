package edu.bzu.fdick.servlet;

import edu.bzu.fdick.entity.Course;
import edu.bzu.fdick.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@WebServlet(urlPatterns = "/course/search")
public class CourseSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
//        System.out.println(beginDate+"      "+endDate);
        try {
            String beginDate = req.getParameter("beginDate");
            String endDate = req.getParameter("endDate");
            System.out.println(beginDate+"      "+endDate);
            CourseService courseService = new CourseService();
            List<Course> courses = courseService.getCourseByTime(beginDate, endDate);
            System.out.println(courses);
            req.setAttribute("courses",courses);
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        } catch (ParseException e) {
            e.getMessage();
         }
//        finally {
//            req.getRequestDispatcher("/index.jsp").forward(req,resp);
//        }


    }
}

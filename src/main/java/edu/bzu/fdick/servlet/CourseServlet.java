package edu.bzu.fdick.servlet;

import edu.bzu.fdick.entity.Course;
import edu.bzu.fdick.service.CourseService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/courseServlet")
public class CourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String opera = req.getParameter("opera");
        System.out.println(opera);
        if (opera==null){
            findAll(req,resp);
            return;
        }
        try {
            Method method = this.getClass().getDeclaredMethod(opera, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        CourseService courseService = new CourseService();
        List<Course> courses = courseService.getAllCourse();
        req.setAttribute("courses",courses);
        Object user = req.getSession().getAttribute("user");
        req.setAttribute("user",user);
        System.out.println(req.getSession().getAttribute("user")+"   find kec");
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    protected void addCourse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("addCourse+++++++++++++");
        String couname = req.getParameter("couname");
        String miaoshu = req.getParameter("miaoshu");
        String teacher = req.getParameter("teacher");
        Course course = new Course();
        course.setCouname(couname);
        course.setMiaoshu(miaoshu);
        course.setTeacher(teacher);
        boolean b = new CourseService().insertCourse(course);
        if (b) {
            findAll(req, resp);
        }
    }
    protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id);
        boolean b = new CourseService().delCourse(Integer.parseInt(id));
        if (b) {
            findAll(req, resp);
        }

    }
}

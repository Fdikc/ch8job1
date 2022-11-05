package edu.bzu.fdick.servlet;

import edu.bzu.fdick.entity.Course;
import edu.bzu.fdick.service.CourseService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/courseDetailsServlet")
public class CourseDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String id = req.getParameter("id");
        Course course = new CourseService().getCourseById(Integer.parseInt(id));
        req.setAttribute("course",course);
        req.getRequestDispatcher("/details.jsp").forward(req,resp);
    }
}

package edu.bzu.fdick.servlet;

import edu.bzu.fdick.entity.User;
import edu.bzu.fdick.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/user")
public class Userservlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username,password);
        boolean login = new UserService().login(user);
        if (login){
            session.setAttribute("user",user);
            resp.sendRedirect(contextPath+"/courseServlet");
            //System.out.println("登录成功+++++"+session.getAttribute("user"));
        }else {
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);

        }
    }
}

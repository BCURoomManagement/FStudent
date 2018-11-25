package com.overseas.servlet.usersServlet;

import com.overseas.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset= UTF-8");
        PrintWriter out=resp.getWriter();


        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String password = new String(req.getParameter("password").getBytes("iso8859-1"),"UTF-8");

        out.print(new UserDao().checkUser(username,password));

    }
}

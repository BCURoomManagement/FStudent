package com.overseas.servlet.UsersServlet;

import com.overseas.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset= UTF-8");
        PrintWriter out=resp.getWriter();


        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String password = new String(req.getParameter("password").getBytes("iso8859-1"),"UTF-8");
        String type = new String(req.getParameter("type").getBytes("iso8859-1"),"UTF-8");

        if(new UserDao().checkUserName(username))
        {
            out.print(new UserDao().insertUser(username,password,type));
        }
        else
            out.print("repeat"); //重名

    }
}

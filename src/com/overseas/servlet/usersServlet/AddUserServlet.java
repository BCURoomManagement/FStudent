package com.overseas.servlet.usersServlet;

import com.overseas.dao.UserDao;
import com.overseas.dao.WckDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset= UTF-8");
        PrintWriter out=resp.getWriter();


        String username = new String(req.getParameter("username").getBytes("UTF-8"),"UTF-8");
        String password = new String(req.getParameter("password").getBytes("UTF-8"),"UTF-8");
        String type = new String(req.getParameter("type").getBytes("UTF-8"),"UTF-8");

        if(new UserDao().checkUserName(username))
        {
            out.print(new UserDao().insertUser(username,password,type));
            new WckDao().insertWck(username);
        }
        else
            out.print("repeat"); //重名

    }
}

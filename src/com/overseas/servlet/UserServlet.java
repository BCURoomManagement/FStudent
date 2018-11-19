package com.overseas.servlet;

import com.overseas.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset= UTF-8");
        PrintWriter out=resp.getWriter();
        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String password = new String(req.getParameter("password").getBytes("iso8859-1"),"UTF-8");
        //登录操作
        boolean rs=new UserDao().checkUser(username,password);
        if(rs)
            out.println("true");
        else
            out.println("false");

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset= UTF-8");
        PrintWriter out=resp.getWriter();
        /**
         * 规定 uType
         * 1.注册操作
         * 2.删除操作
         * 3.修改操作
         */
        String uType = new String(req.getParameter("utype").getBytes("iso8859-1"),"UTF-8");

        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String oldusername = new String(req.getParameter("oldusername").getBytes("iso8859-1"),"UTF-8");
        String password = new String(req.getParameter("password").getBytes("iso8859-1"),"UTF-8");
        String type = new String(req.getParameter("type").getBytes("iso8859-1"),"UTF-8");

        switch (uType)
        {
            case "1":
                boolean rs0=new UserDao().checkUserName(username);
                if(rs0){

                    boolean rs1=new UserDao().insertUser(username,password,type);
                    if (rs1)
                        out.println("true");
                    else
                        out.println("false");

                }else
                    out.println("repeat"); //存在重名现象
                break;

            case "2":
                boolean rs2=new UserDao().deleteUser(username);
                if (rs2)
                    out.println("true");
                else
                    out.println("false");
                break;

            case "3":
                boolean rs3=new UserDao().changeUser(oldusername,username,password,type);
                if (rs3)
                    out.println("true");
                else
                    out.println("false");
                break;
        }



    }
}

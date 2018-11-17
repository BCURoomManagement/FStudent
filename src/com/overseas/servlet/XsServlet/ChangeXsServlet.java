package com.overseas.servlet.XsServlet;

import com.overseas.dao.XsDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangeXsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

        PrintWriter out=resp.getWriter();


        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String papers = new String(req.getParameter("papers").getBytes("iso8859-1"),"UTF-8");
        String time = new String(req.getParameter("time").getBytes("iso8859-1"),"UTF-8");
        String periodical = new String(req.getParameter("periodical").getBytes("iso8859-1"),"UTF-8");

        out.print(new XsDao().changeXs(username, papers, time, periodical));

    }
}

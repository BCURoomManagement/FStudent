package com.overseas.servlet.xsServlet;

import com.overseas.dao.XsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/DeleteXsServlet")
public class DeleteXsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

        PrintWriter out=resp.getWriter();
        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");

        out.print(new XsDao().deleteXs(username));

    }
}

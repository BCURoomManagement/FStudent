package com.overseas.servlet.contactServlet;

import com.overseas.dao.ContactDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/DeleteContactServlet")
public class DeleteContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        boolean rs2=new ContactDao().deleteContact(username);
        out.print(rs2);
    }
}

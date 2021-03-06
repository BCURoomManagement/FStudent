package com.overseas.servlet.contactServlet;

import com.overseas.dao.ContactDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ChangeContactServlet")

public class ChangeContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("UTF-8"),"UTF-8");
        String name = new String(req.getParameter("name").getBytes("UTF-8"),"UTF-8");
        String tel = new String(req.getParameter("tel").getBytes("UTF-8"),"UTF-8");
        String fax = new String(req.getParameter("fax").getBytes("UTF-8"),"UTF-8");
        String address = new String(req.getParameter("address").getBytes("UTF-8"),"UTF-8");
        String typ = new String(req.getParameter("typ").getBytes("UTF-8"),"UTF-8");

        boolean rs3=new ContactDao().changeContact(username, name, tel, fax, address);
        out.print(rs3);

    }
}

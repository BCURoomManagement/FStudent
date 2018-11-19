package com.overseas.servlet.contactServlet;

import com.overseas.dao.ContactDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddContactServlet")
public class AddContactServlet extends HttpServlet {
    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String name = new String(req.getParameter("name").getBytes("iso8859-1"),"UTF-8");
        String tel = new String(req.getParameter("tel").getBytes("iso8859-1"),"UTF-8");
        String fax = new String(req.getParameter("fax").getBytes("iso8859-1"),"UTF-8");
        String address = new String(req.getParameter("address").getBytes("iso8859-1"),"UTF-8");


        boolean rs1=new ContactDao().insertContact(username, name, tel, fax, address);
        out.print(rs1);


    }
}

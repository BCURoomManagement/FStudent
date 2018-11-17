package com.overseas.servlet.contactServlet;

import com.overseas.dao.ContactDao;
import com.overseas.entity.Contact;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/GetContactByNameServlet")
public class GetContactByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");

        Contact c=new ContactDao().getContactByName(username);
        JSONArray ja= JSONArray.fromObject(c);
        out.print(ja);

    }
}

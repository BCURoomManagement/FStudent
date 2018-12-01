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
import java.util.ArrayList;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
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
        String type = new String(req.getParameter("type").getBytes("UTF-8"),"UTF-8");


        switch (type)
        {
            case "1":
                boolean rs1=new ContactDao().insertContact(username, name, tel, fax, address);
                 out.print(rs1);
                break;

            case "2":
                boolean rs2=new ContactDao().deleteContact(username);
                out.print(rs2);
                break;

            case "3":
                boolean rs3=new ContactDao().changeContact(username, name, tel, fax, address);
                out.print(rs3);
                break;

            case "4":
                Contact c=new ContactDao().getContactByName(username);
                JSONArray ja= JSONArray.fromObject(c);
                out.print(ja);
                break;

            case "5":
                ArrayList<Contact> list=new ContactDao().getAllContact();

                JSONArray ja2=JSONArray.fromObject(list);
                out.print(ja2);
                break;

        }

    }
}

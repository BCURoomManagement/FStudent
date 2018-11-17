package com.overseas.servlet.ContactServlet;

import com.overseas.dao.ContactDao;
import com.overseas.entity.Contact;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GetAllContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");
        PrintWriter out=resp.getWriter();

        ArrayList<Contact> list=new ContactDao().getAllContact();

        JSONArray ja2=JSONArray.fromObject(list);
        out.print(ja2);


    }
}

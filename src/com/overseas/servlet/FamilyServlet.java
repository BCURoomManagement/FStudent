package com.overseas.servlet;

import com.overseas.dao.FamilyDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FamilyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("UTF-8"),"UTF-8");
        String name = new String(req.getParameter("name").getBytes("UTF-8"),"UTF-8");
        String age = new String(req.getParameter("age").getBytes("UTF-8"),"UTF-8");
        String employment = new String(req.getParameter("employment").getBytes("UTF-8"),"UTF-8");
        String tel = new String(req.getParameter("tel").getBytes("UTF-8"),"UTF-8");
        String type = new String(req.getParameter("type").getBytes("UTF-8"),"UTF-8");
        String utype = new String(req.getParameter("utype").getBytes("UTF-8"),"UTF-8");

        switch (utype)
        {
            case "1":
                out.print(new FamilyDao().insertFamily(username, name, age, employment, tel, type));
                break;
            case "2":
                out.print(new FamilyDao().deleteFamily(username));
                break;
            case "3":
                out.print(new FamilyDao().changeFamily(username, name, age, employment, tel, type));
                break;
            case "4":
                JSONArray ja=JSONArray.fromObject(new FamilyDao().getFamilyByName(username));
                out.print(ja);
                break;
            case "5":
                JSONArray ja2=JSONArray.fromObject(new FamilyDao().getAllFamily());
                out.print(ja2);
        }

    }
}

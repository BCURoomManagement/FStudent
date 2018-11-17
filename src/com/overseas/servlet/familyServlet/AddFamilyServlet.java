package com.overseas.servlet.familyServlet;

import com.overseas.dao.FamilyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/AddFamilyServlet")
public class AddFamilyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String name = new String(req.getParameter("name").getBytes("iso8859-1"),"UTF-8");
        String age = new String(req.getParameter("age").getBytes("iso8859-1"),"UTF-8");
        String employment = new String(req.getParameter("employment").getBytes("iso8859-1"),"UTF-8");
        String tel = new String(req.getParameter("tel").getBytes("iso8859-1"),"UTF-8");
        String type = new String(req.getParameter("type").getBytes("iso8859-1"),"UTF-8");

        out.print(new FamilyDao().insertFamily(username, name, age, employment, tel, type));



    }
}

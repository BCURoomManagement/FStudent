package com.overseas.servlet.xsServlet;

import com.overseas.dao.XsDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/GetXsByNameServlet")
public class GetXsByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

        PrintWriter out=resp.getWriter();
        String username = new String(req.getParameter("username").getBytes("UTF-8"),"UTF-8");

        JSONArray ja=JSONArray.fromObject(new XsDao().getXsByName(username));
        out.print(ja);


    }
}

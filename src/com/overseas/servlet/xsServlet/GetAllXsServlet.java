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
@WebServlet("/GetAllXsServlet")
public class GetAllXsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

        PrintWriter out=resp.getWriter();
        JSONArray ja=JSONArray.fromObject(new XsDao().getAllXs());
        out.print(ja);

    }
}

package com.overseas.servlet.pinfServlet;

import com.overseas.dao.PinfDao;
import com.overseas.entity.Pinf;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/GetPinfByNameServlet")
public class GetPinfByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();
        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        Pinf p=new PinfDao().getPinfByName(username);
        JSONArray ja=JSONArray.fromObject(p);
        out.print(ja);
    }
}

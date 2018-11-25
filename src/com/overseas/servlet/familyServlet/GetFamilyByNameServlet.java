package com.overseas.servlet.familyServlet;

import com.overseas.dao.FamilyDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/GetFamilyByNameServlet")
public class GetFamilyByNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");

        JSONObject ja = new JSONObject();
        ja.put("Father",JSONArray.fromObject(new FamilyDao().getFamilyByName(username,"1")));
        ja.put("Mother",JSONArray.fromObject(new FamilyDao().getFamilyByName(username,"2")));
        ja.put("Daughter",JSONArray.fromObject(new FamilyDao().getFamilyByName(username,"3")));
        ja.put("Spouse",JSONArray.fromObject(new FamilyDao().getFamilyByName(username,"4")));
        out.print(ja);
    }
}

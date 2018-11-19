package com.overseas.servlet;

import com.overseas.dao.StudyDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StudyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("UTF-8"),"UTF-8");
        String unit = new String(req.getParameter("unit").getBytes("UTF-8"),"UTF-8");
        String btime = new String(req.getParameter("btime").getBytes("UTF-8"),"UTF-8");
        String ltime = new String(req.getParameter("ltime").getBytes("UTF-8"),"UTF-8");
        String obj = new String(req.getParameter("obj").getBytes("UTF-8"),"UTF-8");
        String type = new String(req.getParameter("type").getBytes("UTF-8"),"UTF-8");

        switch (type)
        {
            case "1":
                out.print(new StudyDao().insertStudy(username, unit, btime, ltime, obj));
                break;

            case "2":
                out.print(new StudyDao().deleteStudy(username));
                break;

            case "3":
                out.print(new StudyDao().changeStudy(username, unit, btime, ltime, obj));
                break;

            case "4":
                JSONArray ja=JSONArray.fromObject(new StudyDao().getStudyByName(username));
                out.print(ja);
                break;

            case "5":
                JSONArray ja2=JSONArray.fromObject(new StudyDao().getAllStudy());
                out.print(ja2);
                break;
        }

    }
}

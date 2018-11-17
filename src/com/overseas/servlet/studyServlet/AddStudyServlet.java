package com.overseas.servlet.studyServlet;

import com.overseas.dao.StudyDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/AddStudyServlet")
public class AddStudyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String unit = new String(req.getParameter("unit").getBytes("iso8859-1"),"UTF-8");
        String btime = new String(req.getParameter("btime").getBytes("iso8859-1"),"UTF-8");
        String ltime = new String(req.getParameter("ltime").getBytes("iso8859-1"),"UTF-8");
        String obj = new String(req.getParameter("obj").getBytes("iso8859-1"),"UTF-8");

        out.print(new StudyDao().insertStudy(username, unit, btime, ltime, obj));
    }
}

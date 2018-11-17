package com.overseas.servlet.ProposedServlet;

import com.overseas.dao.ProposedDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangeProposedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String degree = new String(req.getParameter("degree").getBytes("iso8859-1"),"UTF-8");
        String subject = new String(req.getParameter("subject").getBytes("iso8859-1"),"UTF-8");
        String ym_f = new String(req.getParameter("ym_f").getBytes("iso8859-1"),"UTF-8");
        String ym_l = new String(req.getParameter("ym_l").getBytes("iso8859-1"),"UTF-8");
        String details = new String(req.getParameter("details").getBytes("iso8859-1"),"UTF-8");
        out.print(new ProposedDao().changeProposed(username, degree, subject, ym_f, ym_l, details));
    }
}

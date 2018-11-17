package com.overseas.servlet.ProposedServlet;

import com.overseas.dao.ProposedDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteProposedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");
        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");

        PrintWriter out=resp.getWriter();
        out.print(new ProposedDao().deleteProposed(username));
    }
}

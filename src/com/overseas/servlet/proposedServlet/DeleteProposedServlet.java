package com.overseas.servlet.proposedServlet;

import com.overseas.dao.ProposedDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/DeleteProposedServlet")
public class DeleteProposedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");
        String username = new String(req.getParameter("username").getBytes("UTF-8"),"UTF-8");

        PrintWriter out=resp.getWriter();
        out.print(new ProposedDao().deleteProposed(username));
    }
}

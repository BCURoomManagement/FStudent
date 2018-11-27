package com.overseas.servlet.stateServlet;

import com.overseas.dao.StateDao;
import com.overseas.dao.WckDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/AddStateServlet")
public class AddStateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String state = new String(req.getParameter("state").getBytes("iso8859-1"),"UTF-8");
        String pay = new String(req.getParameter("pay").getBytes("iso8859-1"),"UTF-8");
        String paytime = new String(req.getParameter("paytime").getBytes("iso8859-1"),"UTF-8");
        String mentality = new String(req.getParameter("mentality").getBytes("iso8859-1"),"UTF-8");
        String applytime = new String(req.getParameter("applytime").getBytes("iso8859-1"),"UTF-8");
        String typ = new String(req.getParameter("typ").getBytes("iso8859-1"),"UTF-8");
        new WckDao().changeWck(username,typ);

        out.print(new StateDao().insertState(username, state, pay, paytime, mentality, applytime));


    }
}

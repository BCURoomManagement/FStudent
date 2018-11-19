package com.overseas.servlet.stateServlet;

import com.overseas.dao.StateDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/StateServlet")
public class StateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("UTF-8"),"UTF-8");
        String state = new String(req.getParameter("state").getBytes("UTF-8"),"UTF-8");
        String pay = new String(req.getParameter("pay").getBytes("UTF-8"),"UTF-8");
        String paytime = new String(req.getParameter("paytime").getBytes("UTF-8"),"UTF-8");
        String mentality = new String(req.getParameter("mentality").getBytes("UTF-8"),"UTF-8");
        String applytime = new String(req.getParameter("applytime").getBytes("UTF-8"),"UTF-8");
        String type = new String(req.getParameter("type").getBytes("UTF-8"),"UTF-8");

        switch (type)
        {
            case "1":
                out.print(new StateDao().insertState(username, state, pay, paytime, mentality, applytime));
                break;

            case "2":
                out.print(new StateDao().deleteState(username));
                break;

            case "3":
                out.print(new StateDao().changeState(username, state, pay, paytime, mentality, applytime));
                break;

            case "4":
                JSONArray ja=JSONArray.fromObject(new StateDao().getStateByName(username));
                out.print(ja);
                break;

            case "5":
                JSONArray ja2=JSONArray.fromObject(new StateDao().getAllState());
                out.print(ja2);
        }

    }
}

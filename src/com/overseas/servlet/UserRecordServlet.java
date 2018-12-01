package com.overseas.servlet;

import com.overseas.dao.PinfDao;
import com.overseas.dao.StateDao;
import com.overseas.entity.Pinf;
import com.overseas.entity.State;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/UserRecordServlet")
public class UserRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=UTF-8");
        String fname=null;
        String lname = null;
        PrintWriter out=response.getWriter();

        String username =  URLDecoder.decode(request.getParameter("username"),"UTF-8");

        Pinf p=new PinfDao().getPinfByName(username);
        fname=p.getGivenName();
        lname=p.getFamilyName();
        String name = fname+"."+lname;

        State s=new StateDao().getStateByName(username);

        s.setUsername(name);

        JSONArray ja=JSONArray.fromObject(s);
        out.print(ja);
        out.flush();
        out.close();
    }
}

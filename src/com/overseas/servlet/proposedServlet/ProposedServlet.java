package com.overseas.servlet.proposedServlet;

import com.overseas.dao.ProposedDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ProposedServlet")
public class ProposedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("UTF-8"),"UTF-8");
        String degree = new String(req.getParameter("degree").getBytes("UTF-8"),"UTF-8");
        String subject = new String(req.getParameter("subject").getBytes("UTF-8"),"UTF-8");
        String ym_f = new String(req.getParameter("ym_f").getBytes("UTF-8"),"UTF-8");
        String ym_l = new String(req.getParameter("ym_l").getBytes("UTF-8"),"UTF-8");
        String details = new String(req.getParameter("details").getBytes("UTF-8"),"UTF-8");
        String type = new String(req.getParameter("type").getBytes("UTF-8"),"UTF-8");


        switch (type)
        {
            case "1":
                out.print(new ProposedDao().insertProposed(username, degree, subject, ym_f, ym_l, details));
                break;

            case "2":
                out.print(new ProposedDao().deleteProposed(username));
                break;

            case "3":
                out.print(new ProposedDao().changeProposed(username, degree, subject, ym_f, ym_l, details));
                break;

            case "4":
                JSONArray ja=JSONArray.fromObject(new ProposedDao().getProposedByName(username));
                out.print(ja);
                break;

            case "5":
                JSONArray ja2=JSONArray.fromObject(new ProposedDao().getAllProposed());
                out.print(ja2);
                break;



        }


    }
}

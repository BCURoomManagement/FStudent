package com.overseas.servlet.xsServlet;

import com.overseas.dao.XsDao;
import com.overseas.entity.Xs;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/XsServlet")
public class XsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

        PrintWriter out=resp.getWriter();


        String username = new String(req.getParameter("username").getBytes("UTF-8"),"UTF-8");
        String papers = new String(req.getParameter("papers").getBytes("UTF-8"),"UTF-8");
        String time = new String(req.getParameter("time").getBytes("UTF-8"),"UTF-8");
        String periodical = new String(req.getParameter("periodical").getBytes("UTF-8"),"UTF-8");
        String type = new String(req.getParameter("periodical").getBytes("UTF-8"),"UTF-8");

        /**
         * type
         *1.增加
         * 2.删除
         * 3.更改
         * 4.查询通过姓名
         * 5.返回所有
         * */

        switch (type)
        {
            case "1":
                boolean rs1=new XsDao().insertXs(username, papers, time, periodical);
                if (rs1)
                    out.print("true");
                else
                    out.print("false");
                break;

            case "2":
                boolean rs2=new XsDao().deleteXs(username);
                if (rs2)
                    out.print("true");
                else
                    out.print("false");
                break;

            case "3":
                boolean rs3=new XsDao().changeXs(username, papers, time, periodical);
                if (rs3)
                    out.print("true");
                else
                    out.print("false");
                break;

            case "4":
                ArrayList x=new XsDao().getXsByName(username);
                JSONArray ja=JSONArray.fromObject(x);
                out.print(ja);
                break;

            case "5":
                ArrayList<Xs> list=new XsDao().getAllXs();
                JSONArray ja2=JSONArray.fromObject(list);
                out.print(ja2);
                break;

        }


    }
}

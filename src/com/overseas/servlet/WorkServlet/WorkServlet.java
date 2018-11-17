package com.overseas.servlet.WorkServlet;

import com.overseas.dao.UserDao;
import com.overseas.dao.WorkDao;
import com.overseas.entity.Work;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String unit = new String(req.getParameter("unit").getBytes("iso8859-1"),"UTF-8");
        String btime = new String(req.getParameter("btime").getBytes("iso8859-1"),"UTF-8");
        String ltime = new String(req.getParameter("ltime").getBytes("iso8859-1"),"UTF-8");
        String obj = new String(req.getParameter("obj").getBytes("iso8859-1"),"UTF-8");
        String type = new String(req.getParameter("type").getBytes("iso8859-1"),"UTF-8");
        /**
         * 规定 Type
         * 1.插入work
         * 2.删除work
         * 3.更改work
         * 4.查询work通过用户名
         * 5.返回所有
         */

        switch (type)
        {
            case "1":
                boolean rs1=new WorkDao().insertWork(username, unit, btime, ltime);
                if (rs1)
                    out.print("true");
                else
                    out.print("false");

                break;


            case "2":
                boolean rs2=new WorkDao().deleteWork(username);
                if (rs2)
                    out.print("true");
                else
                    out.print("false");
                break;

            case "3":
                boolean rs3=new WorkDao().changeWork(username, unit, btime, ltime);
                if (rs3)
                    out.print("true");
                else
                    out.print("false");
                break;


            case "4":
                ArrayList w=new WorkDao().getWorkByName(username);
                JSONArray ja=JSONArray.fromObject(w);
                out.print(ja);
                break;

            case "5":
                ArrayList<Work> list=new WorkDao().getAllWork();
                JSONArray ja2=JSONArray.fromObject(list);
                out.print(ja2);
                break;
        }


    }
}

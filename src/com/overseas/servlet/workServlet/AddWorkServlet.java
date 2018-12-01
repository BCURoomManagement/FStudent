package com.overseas.servlet.workServlet;

import com.overseas.dao.WckDao;
import com.overseas.dao.WorkDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/AddWorkServlet")
public class AddWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();

        String dataarry = URLDecoder.decode(req.getParameter("domains"),"UTF-8");
        String username =  URLDecoder.decode(req.getParameter("username"),"UTF-8");
        String typ = new String(req.getParameter("typ").getBytes("UTF-8"),"UTF-8");
        new WckDao().changeWck(username,typ);
        String unit = null;
        String btime = null;
        String ltime = null;
        String obj = null;

        JSONArray data = JSONArray.fromObject(dataarry);
        for (int i=0 ;i<data.size();i++){
            JSONObject jsonObject  =  data.getJSONObject(i) ;
            unit = jsonObject.getString( "unit") ;
            btime = jsonObject.getString( "btime") ;
            ltime = jsonObject.getString( "ltime") ;
            obj = jsonObject.getString( "obj") ;
            System.out.println(obj);

            new WorkDao().insertWork(username,unit,btime,ltime,obj);
        }
        out.flush();
        out.close();


    }
}

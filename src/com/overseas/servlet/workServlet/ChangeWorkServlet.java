package com.overseas.servlet.workServlet;

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

@WebServlet("/ChangeWorkServlet")
public class ChangeWorkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out=resp.getWriter();

        String dataarry = URLDecoder.decode(req.getParameter("domains"),"UTF-8");
        String username =  URLDecoder.decode(req.getParameter("username"),"UTF-8");
        String typ = URLDecoder.decode(req.getParameter("typ"),"UTF-8");
        String unit = null;
        String btime = null;
        String ltime = null;
        String obj = null;

        new WorkDao().deleteWork(username);

        JSONArray data = JSONArray.fromObject(dataarry);
        for (int i=0 ;i<data.size();i++){
            JSONObject jsonObject  =  data.getJSONObject(i) ;
            unit = jsonObject.getString( "unit") ;
            btime = jsonObject.getString( "btime") ;
            ltime = jsonObject.getString( "ltime") ;
            obj = jsonObject.getString( "obj") ;

            new WorkDao().insertWork(username,unit,btime,ltime,obj);
        }
        out.flush();
        out.close();
    }
}

package com.overseas.servlet.studyServlet;

import com.overseas.dao.StudyDao;
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

@WebServlet("/AddStudyServlet")
public class AddStudyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();
        String dataarry = URLDecoder.decode(req.getParameter("domains"),"UTF-8");
        String username =  URLDecoder.decode(req.getParameter("username"),"UTF-8");
        String unit = null;
        String btime = null;
        String ltime = null;
        String obj = null;

//2、使用JSONArray
        JSONArray data = JSONArray.fromObject(dataarry);
        for (int i=0 ;i<data.size();i++){
            JSONObject   jsonObject  =  data.getJSONObject(i) ;
            System.out.println(data);
             unit = jsonObject.getString( "Previous") ;
             btime = jsonObject.getString( "fromdate") ;
             ltime = jsonObject.getString( "todate") ;
             obj = jsonObject.getString( "Fields") ;
            new StudyDao().insertStudy(username, unit, btime, ltime, obj);
        }
        out.flush();
        out.close();

//        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
//        String unit = new String(req.getParameter("unit").getBytes("iso8859-1"),"UTF-8");
//        String btime = new String(req.getParameter("btime").getBytes("iso8859-1"),"UTF-8");
//        String ltime = new String(req.getParameter("ltime").getBytes("iso8859-1"),"UTF-8");
//        String obj = new String(req.getParameter("obj").getBytes("iso8859-1"),"UTF-8");


    }
}

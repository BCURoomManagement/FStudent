package com.overseas.servlet.xsServlet;

import com.overseas.dao.WckDao;
import com.overseas.dao.XsDao;
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

@WebServlet("/AddXsServlet")
public class AddXsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");

        PrintWriter out=resp.getWriter();


        String dataarry = URLDecoder.decode(req.getParameter("domains"),"UTF-8");
        String username =  URLDecoder.decode(req.getParameter("username"),"UTF-8");
        String typ = new String(req.getParameter("typ").getBytes("iso8859-1"),"UTF-8");
        new WckDao().changeWck(username,typ);
        String papers = null;
        String time = null;
        String periodical = null;

        JSONArray data = JSONArray.fromObject(dataarry);
        for (int i=0 ;i<data.size();i++){
            JSONObject jsonObject  =  data.getJSONObject(i) ;
            System.out.println(data);
            papers = jsonObject.getString( "papers") ;
            time = jsonObject.getString( "time") ;

            new XsDao().insertXs(username, papers, time);
        }
        out.flush();
        out.close();


    }
}

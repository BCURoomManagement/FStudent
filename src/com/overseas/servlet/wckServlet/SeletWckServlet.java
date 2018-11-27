package com.overseas.servlet.wckServlet;

import com.overseas.dao.WckDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

@WebServlet("/SeletWckServlet")
public class SeletWckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=UTF-8");

        PrintWriter out=response.getWriter();

        String username =  URLDecoder.decode(request.getParameter("username"),"UTF-8");

        out.print(new WckDao().getWckByName(username));

        out.flush();
        out.close();
    }
}

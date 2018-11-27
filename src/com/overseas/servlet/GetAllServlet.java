package com.overseas.servlet;

import com.overseas.dao.getAllDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/GetAllServlet")
public class GetAllServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
       String username = "Zhang";
        getAllDao freemark = new getAllDao("./template",username);//这里如果放在了具体的包名下，需要修改为 "/com/test/template/"
        freemark.setTemplateName("mode.ftl");
        System.out.println(freemark.getTemplateName());
        freemark.setFileName("doc_"+new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(new Date())+".doc");//生成的word名称
        freemark.setFilePath("/Users/ezjjjj/Desktop/markdown/");//生成word存储路径
        freemark.createWord();//生成方法
    }
}

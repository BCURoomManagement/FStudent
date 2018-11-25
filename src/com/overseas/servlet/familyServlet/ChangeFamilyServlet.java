package com.overseas.servlet.familyServlet;

import com.overseas.dao.FamilyDao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ChangeFamilyServlet")
public class ChangeFamilyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();


        String username = new String(req.getParameter("username").getBytes("UTF-8"),"UTF-8");
        String Father = new String(req.getParameter("Father").getBytes("UTF-8"),"UTF-8");
        String Mother = new String(req.getParameter("Mother").getBytes("UTF-8"),"UTF-8");
        String Daughter = new String(req.getParameter("Daughter").getBytes("UTF-8"),"UTF-8");
        String Spouse = new String(req.getParameter("Spouse").getBytes("UTF-8"),"UTF-8");
        JSONObject father  =  JSONObject.fromObject(Father) ;
        JSONObject mother  =  JSONObject.fromObject(Mother) ;
        JSONObject daughter  =  JSONObject.fromObject(Daughter) ;
        JSONObject spouse  =  JSONObject.fromObject(Spouse) ;
        System.out.println("d"+daughter);
        System.out.println("s"+spouse);
        System.out.println(father);
        new FamilyDao().changeFamily(username, father.getString( "FatherName"), father.getString( "FatherNumber"), father.getString( "FatherEmployment"), father.getString( "Fathermail"), "1");
        new FamilyDao().changeFamily(username, mother.getString( "MotherName"), mother.getString( "MotherNumber"), mother.getString( "MotherEmployment"), mother.getString( "Mothermail"), "2");
        new FamilyDao().changeFamily(username, spouse.getString( "SpouseName"), spouse.getString( "SpouseNumber"), spouse.getString( "SpouseEmployment"), spouse.getString( "Spousemail"), "4");
        new FamilyDao().changeFamily(username, daughter.getString( "DaughterName"), daughter.getString( "DaughterNumber"), daughter.getString( "DaughterEmployment"), daughter.getString( "Daughtermail"), "3");
        out.flush();
        out.close();

//        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
//        String name = new String(req.getParameter("name").getBytes("iso8859-1"),"UTF-8");
//        String age = new String(req.getParameter("age").getBytes("iso8859-1"),"UTF-8");
//        String employment = new String(req.getParameter("employment").getBytes("iso8859-1"),"UTF-8");
//        String tel = new String(req.getParameter("tel").getBytes("iso8859-1"),"UTF-8");
//        String type = new String(req.getParameter("type").getBytes("iso8859-1"),"UTF-8");
//
//        out.print(new FamilyDao().changeFamily(username, name, age, employment, tel, type));




    }
}

package com.overseas.servlet.familyServlet;

import com.overseas.dao.FamilyDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/AddFamilyServlet")
public class AddFamilyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();

        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String Father = new String(req.getParameter("Father").getBytes("iso8859-1"),"UTF-8");
        String Mother = new String(req.getParameter("Mother").getBytes("iso8859-1"),"UTF-8");
        String Daughter = new String(req.getParameter("Daughter").getBytes("iso8859-1"),"UTF-8");
        String Spouse = new String(req.getParameter("Spouse").getBytes("iso8859-1"),"UTF-8");

        JSONObject father  =  JSONObject.fromObject(Father) ;
        JSONObject mother  =  JSONObject.fromObject(Mother) ;
        JSONObject daughter  =  JSONObject.fromObject(Daughter) ;
        JSONObject spouse  =  JSONObject.fromObject(Spouse) ;

        System.out.println(father);
        new FamilyDao().insertFamily(username, father.getString( "FatherName"), father.getString( "FatherNumber"), father.getString( "FatherEmployment"), father.getString( "Fathermail"), "1");
        new FamilyDao().insertFamily(username, mother.getString( "MotherName"), mother.getString( "MotherNumber"), mother.getString( "MotherEmployment"), mother.getString( "Mothermail"), "2");
        new FamilyDao().insertFamily(username, spouse.getString( "SpouseName"), spouse.getString( "SpouseNumber"), spouse.getString( "SpouseEmployment"), spouse.getString( "Spousemail"), "4");
        new FamilyDao().insertFamily(username, daughter.getString( "DaughterName"), daughter.getString( "DaughterNumber"), daughter.getString( "DaughterEmployment"), daughter.getString( "Daughtermail"), "3");
    }
}

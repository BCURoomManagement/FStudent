package com.overseas.servlet;

import com.overseas.dao.*;
import com.overseas.entity.Contact;
import com.overseas.entity.Pinf;
import com.overseas.entity.Proficiency;
import com.overseas.entity.Proposed;
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

@WebServlet("/GetAllInfServlet")
public class GetAllInfServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/json;charset=UTF-8");
        response.setCharacterEncoding("utf-8");
        String typ = URLDecoder.decode(request.getParameter("typ"),"UTF-8");
        String username =  URLDecoder.decode(request.getParameter("username"),"UTF-8");

        new WckDao().changeWck(username,typ);
        PrintWriter out=response.getWriter();
        //
        Contact c=new ContactDao().getContactByName(username);
        //
        JSONObject ja = new JSONObject();
        ja.put("Father", JSONArray.fromObject(new FamilyDao().getFamilyByName(username,"1")));
        ja.put("Mother", JSONArray.fromObject(new FamilyDao().getFamilyByName(username,"2")));
        ja.put("Daughter", JSONArray.fromObject(new FamilyDao().getFamilyByName(username,"3")));
        ja.put("Spouse", JSONArray.fromObject(new FamilyDao().getFamilyByName(username,"4")));
        //
        Pinf p=new PinfDao().getPinfByName(username);
        JSONArray ja1= JSONArray.fromObject(p);
        //
        Proficiency pp=new ProficiencyDao().getProficiencyByName(username);
        JSONArray ja2= JSONArray.fromObject(pp);
        //
        Proposed ppp=new ProposedDao().getProposedByName(username);
        JSONArray ja3= JSONArray.fromObject(ppp);
        //
        JSONArray ja4= JSONArray.fromObject(new StudyDao().getStudyByName(username));
        //
        JSONArray ja5= JSONArray.fromObject(new XsDao().getXsByName(username));
        //
        JSONArray ja6=JSONArray.fromObject(new WorkDao().getWorkByName(username));
        //
        //JSONArray ja6=JSONArray.fromObject("["+new UploadDao().chackUploadl(username)+"]");
        //
        JSONObject jal = new JSONObject();
        jal.put("Contact", JSONArray.fromObject(c));
        jal.put("Family", JSONArray.fromObject(ja));
        jal.put("Pinf",ja1);
        jal.put("Proficiency",ja2);
        jal.put("Proposed",ja3);
        jal.put("Study",ja4);
        jal.put("Xs",ja5);
        jal.put("work",ja6);
        out.print(jal);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

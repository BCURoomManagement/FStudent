package com.overseas.servlet.proficiencyServlet;

import com.overseas.dao.ContactDao;
import com.overseas.dao.ProficiencyDao;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ProficiencyServlet")
public class ProficiencyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();
        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");
        String proficiency_c = new String(req.getParameter("proficiency_c").getBytes("iso8859-1"),"UTF-8");
        String level_c=new String(req.getParameter("level_c").getBytes("iso8859-1"),"UTF-8");
        String proficiency_e=new String(req.getParameter("proficiency_e").getBytes("iso8859-1"),"UTF-8");
        String level_e=new String(req.getParameter("level_e").getBytes("iso8859-1"),"UTF-8");
        String type=new String(req.getParameter("type").getBytes("iso8859-1"),"UTF-8");

        switch (type)
        {
            case "1":
                out.print(new ProficiencyDao().insertProficiency(username, proficiency_c, level_c, proficiency_e, level_e));
                break;

            case "2":
                out.print(new ContactDao().deleteContact(username));
                break;

            case "3":
                out.print(new ProficiencyDao().changeProficiency(username, proficiency_c, level_c, proficiency_e, level_e));
                break;

            case "4":
                JSONArray ja=JSONArray.fromObject(new ProficiencyDao().getProficiencyByName(username));
                out.print(ja);
                break;

            case "5":
                JSONArray ja2=JSONArray.fromObject(new ProficiencyDao().getAllProficiency());
                out.print(ja2);
                break;
        }



    }
}

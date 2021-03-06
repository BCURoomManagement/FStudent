package com.overseas.servlet.pinfServlet;

import com.overseas.dao.PinfDao;
import com.overseas.entity.Pinf;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
@WebServlet("/PinfServlet")
public class PinfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();


        String type = new String(req.getParameter("type").getBytes("UTF-8"),"UTF-8");
        /**
         * 规定 Type
         * 1.插入操作
         * 2.删除
         * 3.更改
         * 4.通过用户名查询
         * 5.返回全部
         */

        String username = new String(req.getParameter("username").getBytes("UTF-8"),"UTF-8");
        String pic = new String(req.getParameter("pic").getBytes("UTF-8"),"UTF-8");
        String passport_name = new String(req.getParameter("passport_name").getBytes("UTF-8"),"UTF-8");
        String family_name = new String(req.getParameter("family_name").getBytes("UTF-8"),"UTF-8");
        String given_name = new String(req.getParameter("given_name").getBytes("UTF-8"),"UTF-8");
        String nationality= new String(req.getParameter("nationality").getBytes("UTF-8"),"UTF-8");
        String passport_no = new String(req.getParameter("passport_no").getBytes("UTF-8"),"UTF-8");
        String date_birth = new String(req.getParameter("date_birth").getBytes("UTF-8"),"UTF-8");
        String place_birth = new String(req.getParameter("place_birth").getBytes("UTF-8"),"UTF-8");
        String sex= new String(req.getParameter("sex").getBytes("UTF-8"),"UTF-8");
        String marri= new String(req.getParameter("marri").getBytes("UTF-8"),"UTF-8");
        String religion= new String(req.getParameter("religion").getBytes("UTF-8"),"UTF-8");
        String address_c = new String(req.getParameter("address_c").getBytes("UTF-8"),"UTF-8");
        String ctel= new String(req.getParameter("ctel").getBytes("UTF-8"),"UTF-8");
        String cfax= new String(req.getParameter("cfax").getBytes("UTF-8"),"UTF-8");
        String cmail = new String(req.getParameter("cmail").getBytes("UTF-8"),"UTF-8");
        String address_h= new String(req.getParameter("address_h").getBytes("UTF-8"),"UTF-8");
        String htel = new String(req.getParameter("htel").getBytes("UTF-8"),"UTF-8");
        String hfax = new String(req.getParameter("hfax").getBytes("UTF-8"),"UTF-8");
        String hmail = new String(req.getParameter("hmail").getBytes("UTF-8"),"UTF-8");

        switch (type)
        {
            case "1":
                boolean rs1=new PinfDao().insertPinf(username, pic, passport_name, family_name, given_name, nationality, passport_no, date_birth, place_birth, sex, marri, religion, address_c, ctel, cfax, cmail, address_h, htel, hfax, hmail);
                 if (rs1)
                     out.println("true");
                else
                    out.println("false");
            break;

            case "2":
                boolean rs2=new PinfDao().deletePinf(username);
                if (rs2)
                    out.println("true");
                else
                    out.println("false");
                break;


            case "3":
                boolean rs3=new PinfDao().changePinf(username, pic, passport_name, family_name, given_name, nationality, passport_no, date_birth, place_birth, sex, marri, religion, address_c, ctel, cfax, cmail, address_h, htel, hfax, hmail);
                if(rs3)
                    out.println("true");
                else
                    out.println("false");
                break;

            case "4":
                Pinf p=new PinfDao().getPinfByName(username);
                JSONArray ja=JSONArray.fromObject(p);
                out.print(ja);
                break;


            case "5":
                ArrayList<Pinf> list=new PinfDao().getAllPinf();
                JSONArray ja5=JSONArray.fromObject(list);
                out.print(ja5);
                break;

        }

    }
}

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
@WebServlet("/GetAllPinfServlet")
public class GetAllPinfServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=UTF-8");

        PrintWriter out=resp.getWriter();

        ArrayList<Pinf> list=new PinfDao().getAllPinf();
        JSONArray ja=JSONArray.fromObject(list);
        out.print(ja);

    }
}

package com.overseas.servlet.usersServlet;

import com.overseas.dao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset= UTF-8");
        PrintWriter out=resp.getWriter();


        String username = new String(req.getParameter("username").getBytes("iso8859-1"),"UTF-8");


        out.println("delete Contact:"+new ContactDao().deleteContact(username));
        out.println("delete Family:"+new FamilyDao().deleteFamily(username));
        out.println("delete Pinf:"+new PinfDao().deletePinf(username));
        out.println("delete Proficiency:"+new ProficiencyDao().deleteProficiency(username));
        out.println("delete Proposed:"+new ProposedDao().deleteProposed(username));
        out.println("delete State:"+new StateDao().deleteState(username));
        out.println("delete Study:"+new StudyDao().deleteStudy(username));
        out.println("delete User:"+new UserDao().deleteUser(username));
        out.println("delete Work:"+new WorkDao().deleteWork(username));
        out.println("delete Xs:"+new XsDao().deleteXs(username));
        out.println("delete Xs:"+new WckDao().delWckUsername(username));
    }
}

package com.overseas.dao;

import com.overseas.entity.Proposed;
import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProposedDao {
    DBUtil util=new DBUtil();
    public boolean insertProposed(String username, String degree, String subject, String ym_f, String ym_l, String details)
    {
        String sql="insert into overseas.processed (username,degree,subject,ym_f,ym_l,details) values (?,?,?,?,?,?)";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,degree);
            pstmt.setString(3,subject);
            pstmt.setString(4,ym_f);
            pstmt.setString(5,ym_l);
            pstmt.setString(6,details);
            if (pstmt.executeUpdate()>0)
            {
                conn.close();
                return true;
            }
            conn.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteProposed(String username)
    {
        String sql="delete form overseas.proposed where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            if (pstmt.executeUpdate()>0)
            {
                conn.close();
                return true;
            }
            conn.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean changeProposed(String username, String degree, String subject, String ym_f, String ym_l, String details)
    {
        String sql="update overseas.processed set username=?,degree=?,subject=?,ym_f=?,ym_l=?,details=? where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,degree);
            pstmt.setString(3,subject);
            pstmt.setString(4,ym_f);
            pstmt.setString(5,ym_l);
            pstmt.setString(6,details);
            pstmt.setString(7,username);
            if (pstmt.executeUpdate()>0)
            {
                conn.close();
                return true;
            }
            conn.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public Proposed getProposedByName(String username)
    {
        Proposed p=new Proposed();
        String sql="select * from overseas.processed where usernanme=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
          while (rs.next())
          {
              p.setUsername(rs.getString(1));
              p.setDegree(rs.getString(2));
              p.setSubject(rs.getString(3));
              p.setYm_f(rs.getString(4));
              p.setYm_l(rs.getString(5));
              p.setDetails(rs.getString(6));
          }

            conn.close();
            return p;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Proposed> getAllProposed()
    {
       ArrayList<Proposed> list=new ArrayList<Proposed>();
        String sql="select * from overseas.processed";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                Proposed p=new Proposed();
                p.setUsername(rs.getString(1));
                p.setDegree(rs.getString(2));
                p.setSubject(rs.getString(3));
                p.setYm_f(rs.getString(4));
                p.setYm_l(rs.getString(5));
                p.setDetails(rs.getString(6));
                list.add(p);
            }

            conn.close();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

}

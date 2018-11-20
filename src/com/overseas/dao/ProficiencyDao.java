package com.overseas.dao;

import com.overseas.entity.Proficiency;
import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProficiencyDao {
    DBUtil util=new DBUtil();
    public boolean insertProficiency(String username, String proficiency_c, String level_c, String proficiency_e, String level_e)
    {
        String sql="insert into overseas.proficiency (username,proficiency_c,level_c,proficiency_e,level_e) values(?,?,?,?,?)";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,proficiency_c);
            pstmt.setString(3,level_c);
            pstmt.setString(4,proficiency_e);
            pstmt.setString(5,level_e);

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

    public boolean deleteProficiency(String username)
    {
        String sql="delete overseas.proficiency where username=?";
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

    public boolean changeProficiency(String username, String proficiency_c, String level_c, String proficiency_e, String level_e)
    {
        String sql="update overseas.proficiency set username=?,proficiency_c=?,level_c=?,proficiency_e=?,level_e=? where username=? ";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,proficiency_c);
            pstmt.setString(3,level_c);
            pstmt.setString(4,proficiency_e);
            pstmt.setString(5,level_e);

            pstmt.setString(6,username);
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

    public Proficiency getProficiencyByName(String username)
    {
        Proficiency p=new Proficiency();
        String sql="select * from overseas.proficiency where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                p.setUsername(rs.getString(1));
                p.setProficiency_c(rs.getString(2));
                p.setLevel_c(rs.getString(3));
                p.setProficiency_e(rs.getString(4));
                p.setLevel_e(rs.getString(5));
            }
            conn.close();
            return p;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Proficiency> getAllProficiency()
    {
        ArrayList<Proficiency> list=new ArrayList<Proficiency>();

        String sql="select * from overseas.proficiency";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                Proficiency p=new Proficiency();
                p.setUsername(rs.getString(1));
                p.setProficiency_c(rs.getString(2));
                p.setLevel_c(rs.getString(3));
                p.setProficiency_e(rs.getString(4));
                p.setLevel_e(rs.getString(5));
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

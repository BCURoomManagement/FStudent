package com.overseas.dao;

import com.overseas.entity.Study;
import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudyDao {
    DBUtil util=new DBUtil();
    public boolean insertStudy(String username, String unit, String btime, String ltime, String obj)
    {
        String sql="insert into overseas.study (username,unit,btime,ltime,obj) values (?,?,?,?,?)";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,unit);
            pstmt.setString(3,btime);
            pstmt.setString(4,ltime);
            pstmt.setString(5,obj);
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


    public boolean deleteStudy(String username)
    {
        String sql="delete from overseas.study where username=?";
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


    public boolean changeStudy(String username, String unit, String btime, String ltime, String obj)
    {
        String sql="update overseas.study set username=?,unit=?,btime=?,ltime=?,obj=? where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,unit);
            pstmt.setString(3,btime);
            pstmt.setString(4,ltime);
            pstmt.setString(5,obj);
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


    public ArrayList<Study> getStudyByName(String username)
    {
        ArrayList<Study> list=new ArrayList<Study>();
        String sql="select * from overseas.study where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                Study s=new Study();
                s.setUsername(rs.getString(1));
                s.setUnit(rs.getString(2));
                s.setBtime(rs.getString(3));
                s.setLtime(rs.getString(4));
                s.setObj(rs.getString(5));
                list.add(s);
            }
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Study> getAllStudy()
    {
        ArrayList<Study> list=new ArrayList<Study>();
        String sql="select * from overseas.study";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                Study s=new Study();
                s.setUsername(rs.getString(1));
                s.setUnit(rs.getString(2));
                s.setBtime(rs.getString(3));
                s.setLtime(rs.getString(4));
                s.setObj(rs.getString(5));
                list.add(s);
            }
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

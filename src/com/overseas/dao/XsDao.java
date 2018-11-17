package com.overseas.dao;

import com.overseas.entity.Xs;
import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class XsDao {
    DBUtil util=new DBUtil();
    public boolean insertXs(String username, String papers, String time, String periodical)
    {
        String sql="insert into overseas.xs (username,papers,time,periodical) values (?,?,?,?)";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,papers);
            pstmt.setString(3,time);
            pstmt.setString(4,periodical);
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


    public boolean deleteXs(String username)
    {
        String sql="delete overseas.xs where username=?";
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


    public boolean changeXs(String username, String papers, String time, String periodical)
    {
        String sql="update overseas.xs set username=?, papers=?, time=?, periodical=? where username=?";
        Connection conn=util.getConnection( );
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,papers);
            pstmt.setString(3,time);
            pstmt.setString(4,periodical);
            pstmt.setString(5,username);

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

    public ArrayList<Xs> getXsByName(String username)
    {
        ArrayList<Xs> list=new ArrayList<Xs>();
        String sql="select * from overseas.xs where username=?";
        Connection conn=util.getConnection( );
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                Xs x=new Xs();
                x.setUsername(rs.getString(1));
                x.setPapers(rs.getString(2));
                x.setTime(rs.getString(3));
                x.setPeriodical(rs.getString(4));
                list.add(x);
            }
            conn.close();
            return list;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;

    }


    public ArrayList<Xs> getAllXs()
    {
        String sql="select * from overseas.xs";
        ArrayList<Xs> list=new ArrayList<Xs>();
        Connection conn=util.getConnection( );
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                Xs x=new Xs();
                x.setUsername(rs.getString(1));
                x.setPapers(rs.getString(2));
                x.setTime(rs.getString(3));
                x.setPeriodical(rs.getString(4));
                list.add(x);
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

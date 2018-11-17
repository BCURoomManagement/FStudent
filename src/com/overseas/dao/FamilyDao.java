package com.overseas.dao;

import com.overseas.entity.Family;
import com.overseas.util.DBUtil;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FamilyDao {
    DBUtil util=new DBUtil();
    public boolean insertFamily(String username, String name, String age, String employment, String tel, String type)
    {
        String sql="insert into overseas.family (username,name,age,employment,tel,type)";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,name);
            pstmt.setString(3,age  );
            pstmt.setString(4,employment);
            pstmt.setString(5,tel);
            pstmt.setString(6,type);
            if(pstmt.executeUpdate()>0)
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

    public boolean deleteFamily(String username)
    {
        String sql="delete from overseas.family where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            if(pstmt.executeUpdate()>0)
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

    public boolean changeFamily(String username, String name, String age, String employment, String tel, String type)
    {
        String sql="update  overseas.family set username=?,name=?,age=?,employment=?,tel=?,type=? where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,name);
            pstmt.setString(3,age  );
            pstmt.setString(4,employment);
            pstmt.setString(5,tel);
            pstmt.setString(6,type);
            pstmt.setString(7,username);
            if(pstmt.executeUpdate()>0)
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


    public ArrayList<Family> getFamilyByName(String username)
    {
        ArrayList<Family> list=new ArrayList<Family>();

        String sql="select * from  overseas.family where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                Family f=new Family();
                f.setUsername(rs.getString(1));
                f.setName(rs.getString(2));
                f.setAge(rs.getString(3));
                f.setEmployment(rs.getString(4));
                f.setTel(rs.getString(5));
                f.setType(rs.getString(6));
                list.add(f);
            }
            conn.close();
            return list;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<Family> getAllFamily()
    {
        ArrayList<Family> list=new ArrayList<Family>();
        String sql="select * from  overseas.family";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                Family f=new Family();
                f.setUsername(rs.getString(1));
                f.setName(rs.getString(2));
                f.setAge(rs.getString(3));
                f.setEmployment(rs.getString(4));
                f.setTel(rs.getString(5));
                f.setType(rs.getString(6));
                list.add(f);
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

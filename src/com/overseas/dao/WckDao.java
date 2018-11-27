package com.overseas.dao;

import com.overseas.entity.Upload;
import com.overseas.entity.Wck;
import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WckDao {
    DBUtil util=new DBUtil();
    public boolean insertWck(String username)
    {
        String sql="insert into overseas.wck(username) values(?)";
        Connection conn=util.getConnection();
        try{
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            if(pstmt.executeUpdate()>0)
            {
                conn.close();
                return true;
            }
            conn.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean changeWck(String Username,String type)
    {
        String sql="update overseas.wck set typ=? where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,type);
            pstmt.setString(2,Username);
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
    public boolean delWckUsername(String Username)
    {

        String sql="delete from  overseas.wck where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,Username);

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
    public Wck getWckByName(String username)
    {
        Wck c=new Wck();
        String sql="select typ from overseas.wck where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                c.setTyp(rs.getString(1));
            }
            conn.close();
            return c;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}

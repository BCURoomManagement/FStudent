package com.overseas.dao;

import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

    DBUtil util=new DBUtil();

    //注册
    public boolean insertUser(String username,String password,String type)
    {
        String sql="insert into overseas.login(username,password,type) values(?,?,?)";
        Connection conn=util.getConnection();
        try{
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,type);
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


    //登录检查
    public boolean checkUser(String username,String password){
        String sql="select * from overseas.login where username=? and password=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
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



    //修改用户
    public boolean changeUser(String oldUsername,String username,String password,String type)
    {
        String sql="update overseas.login set username=? ,password=? ,type=? where oldUsername=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            pstmt.setString(3,type);
            pstmt.setString(4,oldUsername);
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

    //删除用户
    public boolean deleteUser(String username)
    {
        String sql="delete from  overseas.login where username=?";
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


    public boolean checkUserName(String username)
    {
        String sql="select * from  overseas.login where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            if (rs.next())
            {
                conn.close();
                return false;
            }
            conn.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }


}

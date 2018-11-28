package com.overseas.dao;

import com.overseas.entity.Contact;
import com.overseas.entity.Upload;
import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UploadDao {
    DBUtil util=new DBUtil();
    public boolean insertUpload(String username, String type,String filename)
    {
        System.out.println("2222");
        int type2 = Integer.parseInt(type);
        String url [] = {"username","pass","intfor","id","tran","certi","two","lelts","hsk","study","pub","non","phy","lelts2","psy","photo"};

        String sql="insert into overseas.upold (username,"+url[type2]+") values(?,?)";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,filename);
            if (pstmt.executeUpdate()>0)
            {
                conn.close();
                return true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean getUploadByName(String username)
    {
        Upload c=new Upload();
        String sql="select * from overseas.upold where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next())
            {
                conn.close();
                return false;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public boolean changeUpload(String username, String type, String filename)
    {
        System.out.println("11111");
        int type2 = Integer.parseInt(type);
        String url [] = {"username","pass","intfor","id","tran","certi","two","lelts","hsk","study","pub","non","phy","lelts2","psy","photo"};
        String sql="update overseas.upold set username=?,"+url[type2]+"=? where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,filename);
            pstmt.setString(3,username);
            if (pstmt.executeUpdate()>0)
            {
                conn.close();
                return true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public boolean chackUpload(String username)
    {
        Upload c=new Upload();
        String sql="select * from overseas.upold where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            if(rs.getString(2)==null||rs.getString(3)==null||rs.getString(4)==null||rs.getString(5)==null||rs.getString(6)==null||rs.getString(7)==null||rs.getString(8)==null||rs.getString(12)==null||rs.getString(13)==null)
            {
                conn.close();
                return false;
            }
            else{
                return true;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return true;
    }
    public String chackUploadl(String username)
    {
        String a ="";
        Upload c=new Upload();
        String sql="select * from overseas.upold where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            rs.next();
            if(rs.getString(2)==null)
            {
                a = a+"/1";
            }
            if(rs.getString(3)==null)
            {
                a = a+"/2";

            }
            if(rs.getString(4)==null)
            {
                a = a+"/3";


            }
            if(rs.getString(5)==null)
            {
                a = a+"/4";


            }
            if(rs.getString(6)==null)
            {
                a = a+"/5";


            }
            if(rs.getString(7)==null)
            {
                a = a+"/6";

            }
            if(rs.getString(8)==null)
            {
                a = a+"/7";


            }
            if(rs.getString(12)==null)
            {
                a = a+"/11";


            }
            if(rs.getString(13)==null)
            {
                a = a+"/12";


            }
            if(rs.getString(14)==null)
            {
                a = a+"/13";


            }
            if(rs.getString(15)==null)
            {
                a = a+"/14";
            }
            else{
                return "0";
            }
            conn.close();
            return a;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return "500";
    }
}

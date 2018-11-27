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
        int type2 = Integer.parseInt(type);
        String url [] = {"username","pass","intfor","id","tran","certi","two","lelts","hsk","study","pub","non","phy","psy","photo"};

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
    public Upload getUploadByName(String username)
    {
        Upload c=new Upload();
        String sql="select * from overseas.upold where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                c.setPass(rs.getString(2));
                c.setIntfor(rs.getString(3));
                c.setId(rs.getString(4));
                c.setTran(rs.getString(5));
                c.setCerti(rs.getString(6));
                c.setTwo(rs.getString(7));
                c.setLelts(rs.getString(8));
                c.setHsk(rs.getString(9));
                c.setStudy(rs.getString(10));
                c.setPub(rs.getString(11));
                c.setNon(rs.getString(12));
                c.setPhy(rs.getString(13));
                c.setPsy(rs.getString(14));
                c.setPhoto(rs.getString(15));

            }
            conn.close();
            return c;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
    public boolean changeUpload(String username, String type, String filename)
    {
        int type2 = Integer.parseInt(type);
        String url [] = {"username","pass","intfor","id","tran","certi","two","lelts","hsk","study","pub","non","phy","psy","photo"};
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
}

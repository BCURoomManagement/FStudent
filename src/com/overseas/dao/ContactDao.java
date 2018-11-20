package com.overseas.dao;

import com.overseas.entity.Contact;
import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ContactDao {
    DBUtil util=new DBUtil();
    public boolean insertContact(String username, String name, String tel, String fax, String address)
    {
        String sql="insert into overseas.contact (username,name,tel,fax,address) values(?,?,?,?,?)";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,name);
            pstmt.setString(3,tel);
            pstmt.setString(4,fax);
            pstmt.setString(5,address);
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


    public boolean deleteContact(String username)
    {
        String sql="delete overseas.contact where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);

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

    public boolean changeContact(String username, String name, String tel, String fax, String address)
    {
        String sql="update overseas.contact set username=?,name=?,tel=?,fax=?,adress=? where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,name);
            pstmt.setString(3,tel);
            pstmt.setString(4,fax);
            pstmt.setString(5,address);
            pstmt.setString(6,username);
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


    public Contact getContactByName(String username)
    {
        Contact c=new Contact();
        String sql="select * from overseas.contact where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                c.setUsername(rs.getString(1));
               c.setName(rs.getString(2));
               c.setTel(rs.getString(3));
               c.setFax(rs.getString(4));
               c.setAddress(rs.getString(5));

            }
            conn.close();
            return c;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



    public ArrayList<Contact> changeContact(String username)
    {
        ArrayList<Contact> list=new ArrayList<Contact>();
        String sql="select * from overseas.contacts";
        Connection conn=util.getConnection();
        try {

            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                Contact c=new Contact();
                c.setUsername(rs.getString(1));
                c.setName(rs.getString(2));
                c.setTel(rs.getString(3));
                c.setFax(rs.getString(4));
                c.setAddress(rs.getString(5));
                list.add(c);
            }
            conn.close();
            return list;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Contact> getAllContact()
    {
        ArrayList<Contact> list=new ArrayList<Contact>();
        String sql="select * from overseas.contacts";
        Connection conn=util.getConnection();
        try {

            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                Contact c=new Contact();
                c.setUsername(rs.getString(1));
                c.setName(rs.getString(2));
                c.setTel(rs.getString(3));
                c.setFax(rs.getString(4));
                c.setAddress(rs.getString(5));
                list.add(c);
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

package com.overseas.dao;

import com.overseas.entity.Work;
import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLRecoverableException;
import java.util.ArrayList;

public class WorkDao {
    DBUtil util = new DBUtil();

    public boolean insertWork(String username, String unit, String btime, String ltime) {
        String sql = "insert into overseas.work (username,unit,btime,ltime) values (?,?,?,?)";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, unit);
            pstmt.setString(3, btime);
            pstmt.setString(4, ltime);
            if (pstmt.executeUpdate() > 0) {
                conn.close();
                return true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean changeWork(String username, String unit, String btime, String ltime) {
        String sql = "update overseas.work set username=?,unit=?,btime=?,ltime=? where username=?";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, unit);
            pstmt.setString(3, btime);
            pstmt.setString(4, ltime);
            pstmt.setString(5,username);
            if (pstmt.executeUpdate() > 0) {
                conn.close();
                return true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean deleteWork(String username) {
        String sql = "delete from overseas.work where username=?";
        Connection conn = util.getConnection();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            if (pstmt.executeUpdate() > 0) {
                conn.close();
                return true;
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<Work> getWorkByName(String username) {
        ArrayList<Work> list=new ArrayList<Work>();

        String sql = "select * from overseas.work where username=?";
        Connection conn = util.getConnection();
        try {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Work w = new Work();
                w.setUsername(rs.getString(1));
                w.setUnit(rs.getString(2));
                w.setBtime(rs.getString(3));
                w.setLtime(rs.getString(4));
                w.setObj(rs.getString(5));
                list.add(w);

            }
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<Work> getAllWork() {

        String sql = "select * from overseas.work";
        Connection conn = util.getConnection();
        ArrayList list = new ArrayList();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Work w = new Work();
                w.setUsername(rs.getString(1));
                w.setUnit(rs.getString(2));
                w.setBtime(rs.getString(3));
                w.setLtime(rs.getString(4));
                w.setObj(rs.getString(5));
                list.add(w);
            }
            conn.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }
}





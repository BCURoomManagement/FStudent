package com.overseas.dao;

import com.overseas.entity.State;
import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StateDao {
    DBUtil util=new DBUtil();
    public boolean insertState(String username, String state, String pay, String paytime, String mentality, String applytime)
    {
        String sql="insert into overseas.state (username,state,pay,paytime,mentality,applytime) values(?,?,?,?,?,?)";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,state);
            pstmt.setString(3,pay);
            pstmt.setString(4,paytime);
            pstmt.setString(5,mentality);
            pstmt.setString(6,applytime);
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

    public boolean deleteState(String username)
    {
        String sql="delete fornm overseas.state where username=?";
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

    public boolean changeState(String username, String state, String pay, String paytime, String mentality, String applytime)
    {
        String sql="update  overseas.state set username=?,state=?,pay=?,paytime=?,mentality=?,applytime=? where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,state);
            pstmt.setString(3,pay);
            pstmt.setString(4,paytime);
            pstmt.setString(5,mentality);
            pstmt.setString(6,applytime);
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

    public State getStateByName(String username)
    {
        State s=new State();
        String sql="select * from overseas.state where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
           while (rs.next())
           {
               s.setUsername(rs.getString(1));
               s.setState(rs.getString(2));
               s.setPay(rs.getString(3));
               s.setPaytime(rs.getString(4));
               s.setMentality(rs.getString(5));
               s.setApplytime(rs.getString(6));

           }
            conn.close();
            return s;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<State> getAllState()
    {

        ArrayList<State> list=new ArrayList<State>();
        String sql="select * from overseas.state";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                State s=new State();
                s.setUsername(rs.getString(1));
                s.setState(rs.getString(2));
                s.setPay(rs.getString(3));
                s.setPaytime(rs.getString(4));
                s.setMentality(rs.getString(5));
                s.setApplytime(rs.getString(6));
                list.add(s);
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

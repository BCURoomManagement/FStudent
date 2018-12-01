package com.overseas.dao;

import com.overseas.entity.State;
import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StateDao {
    DBUtil util=new DBUtil();
    public boolean insertState(String username, String state, String pay, String paytime, String applytime)
    {
        String sql="insert into overseas.state (username,state,pay,paytime,applytime) values(?,?,?,?,?)";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,state);
            pstmt.setString(3,pay);
            pstmt.setString(4,paytime);
            pstmt.setString(5,applytime);
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
        String sql="delete from overseas.state where username=?";
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

    public boolean changeState(String username, String pay, String paytime)
    {
        String sql="update  overseas.state set pay=?,paytime=? where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,pay);
            pstmt.setString(2,paytime);
            pstmt.setString(3,username);
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
               s.setApplytime(rs.getString(5));

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
                s.setApplytime(rs.getString(5));
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

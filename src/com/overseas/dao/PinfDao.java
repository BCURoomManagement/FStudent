package com.overseas.dao;

import com.overseas.entity.Pinf;
import com.overseas.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PinfDao {
    DBUtil util=new DBUtil();
    public boolean insertPinf(String username, String pic, String passportName, String familyName, String givenName, String nationality, String passportNo, String dateBirth, String placeBirth, String sex, String marri, String religion, String addressC, String ctel, String cfax, String cmail, String addressH, String htel, String hfax, String hmail)
    {
        String sql="insert into overseas.pinf (username,pic,passport_name,family_name,given_name,nationality,passport_no,date_birth,place_birth,sex,marri,religion,address_c,ctel,cfax,cmail,address_h,htel,hfax,hmail ) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,pic);
            pstmt.setString(3,passportName);
            pstmt.setString(4,familyName);
            pstmt.setString(5,givenName);
            pstmt.setString(6,nationality);
            pstmt.setString(7,passportNo);
            pstmt.setString(8,dateBirth);
            pstmt.setString(9,placeBirth);
            pstmt.setString(10,sex);
            pstmt.setString(11,marri);
            pstmt.setString(12,religion);
            pstmt.setString(13,addressC);
            pstmt.setString(14,ctel);
            pstmt.setString(15,cfax);
            pstmt.setString(16,cmail);
            pstmt.setString(17,addressH);
            pstmt.setString(18,htel);
            pstmt.setString(19,hfax);
            pstmt.setString(20,hmail);
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

    public boolean changePinf(String username, String pic, String passportName, String familyName, String givenName, String nationality, String passportNo, String dateBirth, String placeBirth, String sex, String marri, String religion, String addressC, String ctel, String cfax, String cmail, String addressH, String htel, String hfax, String hmail)
    {
        String sql="update overseas.pinf set set username=? ,pic=?,passport_name=?,family_name=?,given_name=?,nationality=?,passport_no=?,date_birth=?,place_birth=?,sex=?,marri=?,religion=?,address_c=?,ctel=?,cfax=?,cmail=?,address_h=?,htel=?,hfax=?,hmail=? where username=?";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,pic);
            pstmt.setString(3,passportName);
            pstmt.setString(4,familyName);
            pstmt.setString(5,givenName);
            pstmt.setString(6,nationality);
            pstmt.setString(7,passportNo);
            pstmt.setString(8,dateBirth);
            pstmt.setString(9,placeBirth);
            pstmt.setString(10,sex);
            pstmt.setString(11,marri);
            pstmt.setString(12,religion);
            pstmt.setString(13,addressC);
            pstmt.setString(14,ctel);
            pstmt.setString(15,cfax);
            pstmt.setString(16,cmail);
            pstmt.setString(17,addressH);
            pstmt.setString(18,htel);
            pstmt.setString(19,hfax);
            pstmt.setString(20,hmail);
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

    public boolean deletePinf(String username)
    {
        String sql="delete from overseas.pinf where username=?";
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
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    public Pinf getPinfByName(String username)
    {
        Pinf p=new Pinf();
        String sql="select * from overseas.pinf where username=?";
        Connection conn=util.getConnection();
        try {

            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,username);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {

                p.setUsername(rs.getString(1));
                p.setPic(rs.getString(2));
                p.setPassportName(rs.getString(3));
                p.setFamilyName(rs.getString(4));
                p.setGivenName(rs.getString(5));
                p.setNationality(rs.getString(6));
                p.setPassportNo(rs.getString(7));
                p.setDateBirth(rs.getString(8));
                p.setPlaceBirth(rs.getString(9));
                p.setSex(rs.getString(10));
                p.setMarri(rs.getString(11));
                p.setReligion(rs.getString(12));
                p.setAddressC(rs.getString(13));
                p.setCtel(rs.getString(14));
                p.setCfax(rs.getString(15));
                p.setCmail(rs.getString(16));
                p.setAddressH(rs.getString(17));
                p.setHtel(rs.getString(18));
                p.setHfax(rs.getString(19));
                p.setHmail(rs.getString(20));

            }
            conn.close();

            return p;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }




    public ArrayList<Pinf> getAllPinf()
    {
        ArrayList<Pinf> list=new ArrayList<Pinf>();

        String sql="select * from overseas.pinf ";
        Connection conn=util.getConnection();
        try {
            PreparedStatement pstmt=conn.prepareStatement(sql);
            ResultSet rs=pstmt.executeQuery();
            while (rs.next())
            {
                Pinf p=new Pinf();
                p.setUsername(rs.getString(1));
                p.setPic(rs.getString(2));
                p.setPassportName(rs.getString(3));
                p.setFamilyName(rs.getString(4));
                p.setGivenName(rs.getString(5));
                p.setNationality(rs.getString(6));
                p.setPassportNo(rs.getString(7));
                p.setDateBirth(rs.getString(8));
                p.setPlaceBirth(rs.getString(9));
                p.setSex(rs.getString(10));
                p.setMarri(rs.getString(11));
                p.setReligion(rs.getString(12));
                p.setAddressC(rs.getString(13));
                p.setCtel(rs.getString(14));
                p.setCfax(rs.getString(15));
                p.setCmail(rs.getString(16));
                p.setAddressH(rs.getString(17));
                p.setHtel(rs.getString(18));
                p.setHfax(rs.getString(19));
                p.setHmail(rs.getString(20));
                list.add(p);
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




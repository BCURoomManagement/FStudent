package com.overseas.util;
import java.sql.Connection;
import java.sql.DriverManager;

/***
 * 数据库连接工具类
 * 功能：连接数据库并返回对象
 */

public class DBUtil {
    public Connection getConnection() {//得到数据库连接
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://39.106.208.110:3306/overseas?useUnicode=true&characterEncoding=utf8", "root", "rootroot");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}







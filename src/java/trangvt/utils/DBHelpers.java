/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trangvt.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Trang Mery
 */
public class DBHelpers implements Serializable {
    public static Connection makeConnection() 
        throws /*ClassNotFoundException, SQLException*/ NamingException, SQLException{
        //1. Find context of server - JNDI
        Context context = new InitialContext();
        //2. Find context of contrainer
        Context tomcatContext = (Context)context.lookup("java:comp/env");
        //3. Find DS
        DataSource ds = (DataSource)tomcatContext.lookup("trangvt");
        //4 Open Connection
        Connection con = ds.getConnection();
        
        return con;
    }
    //        //1 Load Driver               
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        //2 Create URL Connection String
//        String url = "jdbc:sqlserver://localhost:1433;"
//                + "databaseName=UserManagement";
////        //3 Open Connection
//        Connection con = DriverManager.getConnection(url, "sa", "");
//        
//        return con;
    
}

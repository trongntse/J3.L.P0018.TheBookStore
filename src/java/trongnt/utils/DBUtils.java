/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnt.utils;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author user
 */
public class DBUtils {
    public static Connection getConnection() throws SQLException, NamingException {
        Connection cn=null;
        Context context=new InitialContext();
        Context envCtx=(Context) context.lookup("java:comp/env");
        DataSource ds=(DataSource) envCtx.lookup("DBConn");
        cn=ds.getConnection();
        return cn;
    }
}

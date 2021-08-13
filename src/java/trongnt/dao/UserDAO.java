/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import org.apache.log4j.Logger;
import trongnt.dto.UserDTO;
import trongnt.utils.DBUtils;

/**
 *
 * @author user
 */
public class UserDAO {
    public static UserDTO checkLogin(String userID, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT UserID, UserName, RoleID"
                        + "   FROM tblUser"
                        + "   WHERE UserID = ? AND Password = ? AND Status = 'True'";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    userID = rs.getString("UserID");
                    String userName = rs.getString("userName");
                    String role = rs.getString("RoleID");
                    user = new UserDTO(userID, userName, role, true);
                }
            }
        } catch (SQLException | NamingException e) {
            Logger.getLogger(UserDAO.class).error("error at UserDAO");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }
    
}

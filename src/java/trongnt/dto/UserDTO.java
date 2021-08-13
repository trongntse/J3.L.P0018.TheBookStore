/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnt.dto;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class UserDTO implements Serializable{
    String userID;
    String userName;
    String phone;
    String password;
    String roleID;
    boolean status;

    public UserDTO(String userID, String userName, String phone, String password, String roleID, boolean status) {
        this.userID = userID;
        this.userName = userName;
        this.phone = phone;
        this.password = password;
        this.roleID = roleID;
        this.status = status;
    }

    public UserDTO(String userID, String userName, String roleID, boolean status) {
        this.userID = userID;
        this.userName = userName;
        this.roleID = roleID;
        this.status = status;
    }

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getRoleID() {
        return roleID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
    
}

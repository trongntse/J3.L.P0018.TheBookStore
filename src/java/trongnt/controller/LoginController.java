/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnt.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import trongnt.dao.UserDAO;
import trongnt.dto.UserDTO;

/**
 *
 * @author user
 */
public class LoginController extends HttpServlet {

    private final static String ERROR = "login.jsp";
    private final static String ADMIN = "AdminLoadAllBookController";
    private final static String USER = "LoadAllBookController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String error="";
        boolean check = true;
        try {
            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");
                       
            UserDTO userLogin = UserDAO.checkLogin(userID, password);
            if (userLogin != null) {
                HttpSession sesstion = request.getSession();
                sesstion.setAttribute("LOGIN_USER", userLogin);
                if (userLogin.getRoleID().equals("US")) {
                    url = USER;
                } else {
                    url = ADMIN;
                }
            }else{
                error="USER NOT FOUND!! ";
                request.setAttribute("ERROR_LOGIN", error);
                check=false;
                return;
            }
        } catch (SQLException e) {
            Logger.getLogger(LoginController.class).error("Error at LoginController");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

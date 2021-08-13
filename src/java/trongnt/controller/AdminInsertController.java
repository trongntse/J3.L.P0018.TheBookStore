/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnt.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import trongnt.dao.BookDAO;
import trongnt.dto.BookDTO;

/**
 *
 * @author user
 */
public class AdminInsertController extends HttpServlet {

   private static final String ERROR = "createPage.jsp";
    private static final String SUCCESS = "AdminLoadAllBookController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String url = ERROR;
        String error = "";
        boolean check = true;
        try {
            String bookID = request.getParameter("txtBookID");
            String bookName = request.getParameter("txtBookName");
            String image = request.getParameter("txtImage");
            String author = request.getParameter("txtAuthor");
            String description = request.getParameter("txtDescription");
            int price = Integer.parseInt(request.getParameter("txtPrice"));
            String categoryID = request.getParameter("txtCategoryID");
            
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            String dateAdded = dateFormat.format(date);
            
            int quantity=Integer.parseInt(request.getParameter("txtQuantity"));
            if (BookDAO.checkDuplicateID(bookID)) {
                error = "BOOK " + bookID + " is already exist!";
                request.setAttribute("ERROR_BOOK", error);
                check = false;
                return;
            }
            
            if (check) {
                BookDTO book=new BookDTO(bookID, bookName, image, author, description, price, categoryID, dateAdded, quantity, true);
                if (BookDAO.insertBook(book)) {
                    request.setAttribute("ERROR_CREATE", error);
                    url = SUCCESS;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(AdminInsertController.class).error("error at AdminInsertController");
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

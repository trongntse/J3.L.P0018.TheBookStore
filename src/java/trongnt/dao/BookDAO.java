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
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import org.apache.log4j.Logger;
import trongnt.dto.BookDTO;
import trongnt.utils.DBUtils;

/**
 *
 * @author user
 */
public class BookDAO {

    public static List<BookDTO> getListBook() {
        List<BookDTO> listBook = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = " Select bookID, bookName, image, author, description, price, categoryID, dateAdded, quantity, status\n"
                        + " From tblBook \n"
                        + " Where status='true' and quantity >0 ";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookName = rs.getString("bookName");
                    String image = rs.getString("image");
                    String author = rs.getString("author");
                    String description = rs.getString("description");
                    int price = rs.getInt("price");
                    String categoryID = rs.getString("categoryID");
                    String dateAdded = rs.getString("dateAdded");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    listBook.add(new BookDTO(bookID, bookName, image, author, description, price, categoryID, dateAdded, quantity, status));
                }
            }
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class).error("error at BookDAO");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            }
        }
        return listBook;
    }

    public static List<BookDTO> getAdminLoadListBook() {
        List<BookDTO> listBook = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = " Select bookID, bookName, image, author, description, price, categoryID, dateAdded, quantity, status\n"
                        + " From tblBook ";

                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookName = rs.getString("bookName");
                    String image = rs.getString("image");
                    String author = rs.getString("author");
                    String description = rs.getString("description");
                    int price = rs.getInt("price");
                    String categoryID = rs.getString("categoryID");
                    String dateAdded = rs.getString("dateAdded");
                    int quantity = rs.getInt("quantity");
                    boolean status = rs.getBoolean("status");
                    listBook.add(new BookDTO(bookID, bookName, image, author, description, price, categoryID, dateAdded, quantity, status));
                }
            }
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class).error("error at BookDAO");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (Exception e) {
            }
        }
        return listBook;
    }

    public static boolean checkDuplicateID(String bookID) throws SQLException {
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {

                String sql = "SELECT bookName\n"
                        + "FROM tblBook\n"
                        + "WHERE bookID=?";
                stm = cn.prepareStatement(sql);
                stm.setString(1, bookID);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = true;
                }
            }
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class).error("error at BookDAO");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (cn != null) {
                cn.close();
            }

        }
        return result;
    }

    public static boolean insertBook(BookDTO book) throws SQLException {
        boolean result = false;
        Connection cn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "INSERT INTO tblBook( bookID, bookName, image, author, description, price, categoryID, dateAdded, quantity, status)\n"
                        + "   VALUES(?,?,?,?,?,?,?,?,?,?)";
                stm = cn.prepareStatement(sql);
                stm.setString(1, book.getBookID());
                stm.setString(2, book.getBookName());
                stm.setString(3, book.getImage());
                stm.setString(4, book.getAuthor());
                stm.setString(5, book.getDescription());
                stm.setInt(6, book.getPrice());
                stm.setString(7, book.getCategoryID());
                stm.setString(8, book.getDateAdded());
                stm.setInt(9, book.getQuantity());
                stm.setBoolean(10, book.isStatus());
                result = stm.executeUpdate() > 0;
            }
        } catch (SQLException | NamingException e) {
            Logger.getLogger(UserDAO.class).error("error at BookDAO");
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return result;
    }

    public static int deleteBook(String bookID, boolean status) {
        int result = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE tblBook\n"
                        + " SET status= ? \n"
                        + " WHERE bookID=?";
                pst = cn.prepareStatement(sql);
                pst.setString(2, bookID);
                pst.setBoolean(1, status);
                result = pst.executeUpdate();
            }

        } catch (SQLException | NamingException e) {
            Logger.getLogger(UserDAO.class).error("error at BookDAO");
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
            }
        }
        return result;
    }

    public static int updateBook(BookDTO book) {
        int result = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "UPDATE tblBook "
                        + " SET bookName=?, image=?, author=?, description=?, price=?, categoryID=?, dateAdded=?, quantity=?, status=?\n"
                        + " WHERE bookID=?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, book.getBookName());
                pst.setString(2, book.getImage());
                pst.setString(3, book.getAuthor());
                pst.setString(4, book.getDescription());
                pst.setInt(5, book.getPrice());
                pst.setString(6, book.getCategoryID());
                pst.setString(7, book.getDateAdded());
                pst.setInt(8, book.getQuantity());
                pst.setBoolean(9, book.isStatus());
                pst.setString(10, book.getBookID());
                result = pst.executeUpdate();
            }

        } catch (SQLException | NamingException e) {
            Logger.getLogger(UserDAO.class).error("error at BookDAO");
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
            }
        }
        return result;
    }

    public static List<BookDTO> searchNameBook(String search) {
        List<BookDTO> listBook = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "SELECT bookID, bookName, image, author, description, price, categoryID, quantity\n"
                        + " FROM tblBook\n"
                        + " WHERE status='true' and  bookName like ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, "%" + search + "%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getString("bookID");
                    String bookName = rs.getString("bookName");
                    String image = rs.getString("image");
                    String author = rs.getString("author");
                    String description = rs.getString("description");
                    int price = rs.getInt("price");
                    String categoryID = rs.getString("categoryID");
                    int quantity = rs.getInt("quantity");
                    listBook.add(new BookDTO(bookID, bookName, image, author, description, price, categoryID, quantity));
                }
            }
        } catch (SQLException | NamingException e) {
            Logger.getLogger(UserDAO.class).error("error at BookDAO");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException e) {
            }
        }
        return listBook;
    }

   

}

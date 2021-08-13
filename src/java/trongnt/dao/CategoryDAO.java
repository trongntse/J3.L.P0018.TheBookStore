/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import trongnt.dto.CategoryDTO;
import trongnt.utils.DBUtils;

/**
 *
 * @author user
 */
public class CategoryDAO {
    public static List<CategoryDTO> getListCate() {
        List<CategoryDTO> listCate = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = " Select categoryID, categoryName\n"
                        + " From tblCategory ";
                       
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String categoryID = rs.getString("categoryID");
                    String categoryName = rs.getString("categoryName");  
                    listCate.add(new CategoryDTO(categoryID, categoryName));
                }
            }
        } catch (Exception e) {
            Logger.getLogger(UserDAO.class).error("error at CategoryDAO");
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
        return listCate;
    }
    
}

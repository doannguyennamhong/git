/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.book;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.utils.DBUtilities;

/**
 *
 * @author HP
 */
public class BookDAO implements Serializable{
    private List<BookDTO> listBooks;

    public List<BookDTO> getListBooks() {
        return listBooks;
    }

   
    
    public boolean insertBook(String bookID, String name, String type, String image, int price) throws NamingException, SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtilities.makeConnection();
            String sql = "Insert into tblBook(BookID,Name,Type,Image,Price,Status) values(?,?,?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, bookID);
            stm.setString(2, name);
            stm.setString(3, type);
            stm.setString(4, image);
            stm.setInt(5, price);
            stm.setBoolean(6, true);
            int check = stm.executeUpdate();
            if (check > 0) {
                return true;
            }
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
        return false;
    }
    
    public void showAll() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "Select BookID,Name,Type,Image,Price,Status from tblBook";
                //3 Create Statement
                stm = con.prepareStatement(sql);
                //4 thuc thi cau lenh
                rs = stm.executeQuery();
                //5 xu li
                if (rs != null) {
                    while (rs.next()) {
                        String bookID = rs.getString("BookID");
                        String name = rs.getString("Name");
                        String type = rs.getString("Type");
                        String image = rs.getString("Image");
                        int price = rs.getInt("Price");
                        boolean status = rs.getBoolean("Status");
                        BookDTO dto=new BookDTO(bookID, name, type, image, price, status);
                        if (this.listBooks == null) {
                            this.listBooks = new ArrayList<>();
                        }
                        this.listBooks.add(dto);
                    }
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
    
    public int getPrice(String name) throws NamingException,SQLException{
        int result=0;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean check=false;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "Select Price from tblBook Where Name=?";
                //3 Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                //4 thuc thi cau lenh
                rs = stm.executeQuery();
                //5 xu li
                if (rs.next()) {
                    result=rs.getInt("Price");
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}

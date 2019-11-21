/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.cart;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.book.BookDTO;
import sample.utils.DBUtilities;

/**
 *
 * @author HP
 */
public class CartDAO implements Serializable{
    
    
    public boolean checkOut(String orderID,String phone,LocalDate date,String products,int totalPrice) throws NamingException,SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        Date sqlDate=Date.valueOf(date);
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                //2 Create sql statement
                String sql = "Insert into tblOrder(OrderID,Phone,Date,Products,TotalPrice,Status) values(?,?,?,?,?)";
                //3 Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, orderID);
                stm.setString(2, phone);
                stm.setDate(3, sqlDate);
                stm.setString(4, products);
                stm.setInt(5, totalPrice);
                stm.setBoolean(6, false);
                //4 thuc thi cau lenh
                int row = stm.executeUpdate();
                //5 xu li
                if (row > 0) {
                    return true;
                }

            }//end if con
        } finally {

            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }

        }
        return false;
    }
    
    public boolean checkOrderIDExisted(String orderID) throws NamingException,SQLException{
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        boolean check=false;
        try {
            con = DBUtilities.makeConnection();
            if (con != null) {
                String sql = "Select Phone from tblOrder Where OrderID=?";
                //3 Create Statement
                stm = con.prepareStatement(sql);
                stm.setString(1, orderID);
                //4 thuc thi cau lenh
                rs = stm.executeQuery();
                //5 xu li
                if (rs.next()) {
                    check=true;
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
        return check;
    }
}

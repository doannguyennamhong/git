/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import sample.utils.DBUtilities;

/**
 *
 * @author HP
 */
public class UserDAO implements Serializable{
    public int checkLogin(String phone,String password) throws NamingException,SQLException{
        //1 connect database
        Connection con=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        int result=-1;
        try {
            con=DBUtilities.makeConnection();
            if(con!=null){
                //2 Create sql statement
                String sql="Select IsAdmin from tblUser where Phone=? and Password=?";
                //3 Create Statement
                stm=con.prepareStatement(sql);
                stm.setString(1, phone);
                stm.setString(2, password);
                //4 thuc thi cau lenh
                rs=stm.executeQuery();
                //5 xu li
                if(rs.next()){
                    result= rs.getInt("IsAdmin");
                }
            }//end if con
        } finally{
           if(con!=null){
               con.close();
           } 
           if(stm!=null){
               stm.close();
           } 
           if(rs!=null){
               rs.close();
           } 
        }
        return result;
    }
    
    public String getUserName(String phone) throws NamingException,SQLException{
        Connection con=null;
        PreparedStatement stm=null;
        ResultSet rs=null;
        String result=null;
        try {
            con=DBUtilities.makeConnection();
            if(con!=null){
                //2 Create sql statement
                String sql="Select Name from tblUser where Phone=?";
                //3 Create Statement
                stm=con.prepareStatement(sql);
                stm.setString(1, phone);
                //4 thuc thi cau lenh
                rs=stm.executeQuery();
                //5 xu li
                if(rs.next()){
                    result= rs.getString("Name");
                }
            }//end if con
        } finally{
           if(con!=null){
               con.close();
           } 
           if(stm!=null){
               stm.close();
           } 
           if(rs!=null){
               rs.close();
           } 
        }
        return result;
    }
}

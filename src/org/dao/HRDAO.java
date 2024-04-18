/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;
import java.sql.*;
import org.model.Employee;
import org.model.HR;
/**
 *
 * @author Divanni
 */
public class HRDAO {
     private String url = "jdbc:postgresql://localhost:5432/HR_Managment_System";
    private String dbUsername = "postgres";
    private String dbPasswd = "Aguerokun10";
    
    public int employees(HR emp){
        try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "Insert into hr(user_id,f_name,l_name,age,email,password) values(?,?,?,?,?,?)";
            PreparedStatement pst =con.prepareStatement(sql);
            pst.setInt(1,emp.getUserID());
            pst.setString(2,emp.getF_name());
            pst.setString(3,emp.getL_name());
            pst.setInt(4,emp.getAge());
            pst.setString(5,emp.getEmail());
            pst.setString(6,emp.getPass());
            int rows = pst.executeUpdate();
            return rows;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
}
}

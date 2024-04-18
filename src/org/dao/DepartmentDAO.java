/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;
import org.model.Department;

/**
 *
 * @author Divanni
 */
public class DepartmentDAO {
    private String url = "jdbc:postgresql://localhost:5432/HR_Managment_System";
    private String dbUsername = "postgres";
    private String dbPasswd = "Aguerokun10";
    public int departments(Department dep){
        try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "Insert into department(dep_id,dep_name,dep_location,dep_head) values(?,?,?,?)";
            PreparedStatement pst =con.prepareStatement(sql);
            pst.setInt(1, dep.getD_Id());
            pst.setString(2, dep.getD_name());
            pst.setString(3, dep.getD_location());
            pst.setString(4, dep.getD_Head());
            int row = pst.executeUpdate();
            return row;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
}
    public void departmentdisplay(DefaultTableModel Model){
        try{
           Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "select* from department";
            PreparedStatement pst =con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();
            while(rs.next()){
                Object[] row = new Object[ cols];  
                for (int i = 0; i < cols; i++) {
                    row[i] = rs.getObject(i+1);
                }
                Model.addRow(row);
            }
        }
        catch(Exception e){
            System.out.println("Employee display error");
            e.printStackTrace();
            
        }
    }
    public Object[] Search(int id){
        try{
           Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "select* from department where dep_id=?";
            PreparedStatement pst =con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData meta= rs.getMetaData();
            int cors = meta.getColumnCount();
            if(rs.next()){
                Object[] row= new Object[cors];
                for(int i=0;i<cors;i++){
                    row[i]=rs.getObject(i+1);
                }
                return row;
            }
            return null;
        }
        catch(Exception e){
            System.out.println("Employee search error");
            e.printStackTrace();
           return null; 
        }
    }
    public int Delete(int id){
        try{
           Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "delete from department where dep_id=?";
            PreparedStatement pst =con.prepareStatement(sql);
            pst.setInt(1, id);
            int row = pst.executeUpdate();
            return row;
        }
        catch(Exception e){
            System.out.println("Employee search error");
            e.printStackTrace();
           return 0; 
        }
    }
    public int Update(Department data) {
     try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "update department set dep_name=?,dep_location=?,dep_head=? where dep_id=?";
            PreparedStatement pst =con.prepareStatement(sql);
           
            pst.setString(1, data.getD_name());
            pst.setString(2, data.getD_location());
            pst.setString(3, data.getD_Head());
            pst.setInt(4, data.getD_Id());
            int row = pst.executeUpdate();
            return row;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}

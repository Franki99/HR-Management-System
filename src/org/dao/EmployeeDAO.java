/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dao;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import org.model.Employee;
/**
 *
 * @author Divanni
 */
public class EmployeeDAO {
    
    private String url = "jdbc:postgresql://localhost:5432/HR_Managment_System";
    private String dbUsername = "postgres";
    private String dbPasswd = "Aguerokun10";
    public int employees(Employee dep){
        try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "Insert into employees(emp_id,f_name,l_name,age,email,department) values(?,?,?,?,?,?)";
            PreparedStatement pst =con.prepareStatement(sql);
            pst.setInt(1, dep.getUserId());
            pst.setString(2, dep.getF_name());
            pst.setString(3, dep.getL_name());
            pst.setInt(4, dep.getAge());
            pst.setString(5, dep.getEmail());
            pst.setString(6, dep.getDep());
            int row = pst.executeUpdate();
            return row;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
}
    public void employeedisplay(DefaultTableModel Model){
        try{
           Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "select* from employees";
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
            String sql = "select* from employees where emp_id=?";
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
            String sql = "delete from employees where emp_id=?";
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

    public int Update(Employee data) {
     try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "update employees set f_name=?,l_name=?,age=?,email=?,department=? where emp_id=?";
            PreparedStatement pst =con.prepareStatement(sql);
           
            pst.setString(1, data.getF_name());
            pst.setString(2, data.getL_name());
            pst.setInt(3, data.getAge());
            pst.setString(4, data.getEmail());
            pst.setString(5, data.getDep());
            pst.setInt(6, data.getUserId());
            int row = pst.executeUpdate();
            return row;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}

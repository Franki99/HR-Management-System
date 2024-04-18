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
import org.model.Candidate;

/**
 *
 * @author Divanni
 */
public class CandidateDAO {
    private String url = "jdbc:postgresql://localhost:5432/HR_Managment_System";
    private String dbUsername = "postgres";
    private String dbPasswd = "Aguerokun10";
    public int candidates(Candidate dep){
        try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "Insert into candidate(candidate_id,f_name,l_name,age,email,education_level) values(?,?,?,?,?,?)";
            PreparedStatement pst =con.prepareStatement(sql);
            pst.setInt(1, dep.getUserId());
            pst.setString(2, dep.getF_name());
            pst.setString(3, dep.getL_name());
            pst.setInt(4, dep.getAge());
            pst.setString(5, dep.getEmail());
            pst.setString(6, dep.getEdu());
            int row = pst.executeUpdate();
            return row;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
}
    public void candidatedisplay(DefaultTableModel Model){
        try{
           Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "select* from candidate";
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
            String sql = "select* from candidate where candidate_id=?";
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
            String sql = "delete from candidate where candidate_id=?";
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
    public int Update(Candidate data) {
     try{
            Connection con = DriverManager.getConnection(url, dbUsername, dbPasswd);
            String sql = "update candidate set f_name=?,l_name=?,age=?,education_level=?,email=? where candidate_id=?";
            PreparedStatement pst =con.prepareStatement(sql);
           
            pst.setString(1, data.getF_name());
            pst.setString(2, data.getL_name());
            pst.setInt(3, data.getAge());
            pst.setString(4, data.getEmail());
            pst.setString(5, data.getEdu());
            pst.setInt(6, data.getUserId());
            int row = pst.executeUpdate();
            return row;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}


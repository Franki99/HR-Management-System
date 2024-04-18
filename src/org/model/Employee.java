/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.model;

/**
 *
 * @author Divanni
 */
public class Employee {
    int userId;
    String F_name;
    String L_name;
    int Age;
    String Email;
    String Dep;

    public Employee() {
    }

    public Employee(int userId, String F_name, String L_name, int Age, String Email, String Dep) {
        this.userId = userId;
        this.F_name = F_name;
        this.L_name = L_name;
        this.Age = Age;
        this.Email = Email;
        this.Dep = Dep;
    }

    public int getUserId() {
        return userId;
    }

    public String getF_name() {
        return F_name;
    }

    public String getL_name() {
        return L_name;
    }

    public int getAge() {
        return Age;
    }

    public String getEmail() {
        return Email;
    }

    public String getDep() {
        return Dep;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setF_name(String F_name) {
        this.F_name = F_name;
    }

    public void setL_name(String L_name) {
        this.L_name = L_name;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setDep(String Dep) {
        this.Dep = Dep;
    }
    
    
}

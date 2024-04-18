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
public class Department {
    int D_Id;
    String D_name;
    String D_location;
    String D_Head;

    public Department() {
    }

    public Department(int D_Id, String D_name, String D_location, String D_Head) {
        this.D_Id = D_Id;
        this.D_name = D_name;
        this.D_location = D_location;
        this.D_Head = D_Head;
    }

    public int getD_Id() {
        return D_Id;
    }

    public String getD_name() {
        return D_name;
    }

    public String getD_location() {
        return D_location;
    }

    public String getD_Head() {
        return D_Head;
    }

    public void setD_Id(int D_Id) {
        this.D_Id = D_Id;
    }

    public void setD_name(String D_name) {
        this.D_name = D_name;
    }

    public void setD_location(String D_location) {
        this.D_location = D_location;
    }

    public void setD_Head(String D_Head) {
        this.D_Head = D_Head;
    }
    
}

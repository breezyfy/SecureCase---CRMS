/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author amir
 */
public class mysqlconnect {
    
    Connection conn = null;
    public static Connection ConnectDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/backend","root","7972797102");
           // JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
           
            return null;
        }
    
    }
    
    public static ObservableList<fir_data> getDatausers(){
        Connection conn = ConnectDb();
        ObservableList<fir_data> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from fir_data");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){ 
                
                list.add(new fir_data(Integer.parseInt(rs.getString("F_ID")), rs.getString("Victim_name"), rs.getString("Suspect_names"), rs.getString("Reported_On"), rs.getString("Crime"),rs.getString("Crime_Details")));               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
        
    }
    
    public static ObservableList<crime_data> getDataCriminals(){
        Connection conn = ConnectDb();
        ObservableList<crime_data> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from crime_data");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){ 
                
                list.add(new crime_data(Integer.parseInt(rs.getString("C_ID")), rs.getString("Criminal_Name"), rs.getString("Crime_Type"),rs.getString("Prison_Details"), rs.getString("Sentenced_On"),rs.getString("Sentenced_Upto")));               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
        
    }
    
    
    
}
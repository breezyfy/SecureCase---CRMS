/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crms;

/**
 *
 * @author pritam
 */
public class crime_data {
    
    int C_ID;
    String Criminal_Name,Crime_Type,Prison_Details,Sentenced_On,Sentenced_Upto;
   
    public int getC_ID() {
        return C_ID;
    }

    public void setC_ID(int C_ID) {
        this.C_ID = C_ID;
    }

    public String getCriminal_Name() {
        return Criminal_Name;
    }

    public void setCriminal_Name(String Criminal_Name) {
        this.Criminal_Name = Criminal_Name;
    }

    public String getCrime_Type() {
        return Crime_Type;
    }

    public void setCrime_Type(String Crime_Type) {
        this.Crime_Type = Crime_Type;
    }

    public String getPrison_Details() {
        return Prison_Details;
    }

    public void setPrison_Details(String Prison_Details) {
        this.Prison_Details = Prison_Details;
    }

    public String getSentenced_On() {
        return Sentenced_On;
    }

    public void setSentenced_On(String Sentenced_On) {
        this.Sentenced_On = Sentenced_On;
    }

    public String getSentenced_Upto() {
        return Sentenced_Upto;
    }

    public void setSentenced_Upto(String Sentenced_Upto) {
        this.Sentenced_Upto = Sentenced_Upto;
    }

    public crime_data(int C_ID, String Criminal_Name, String Crime_Type, String Prison_Details, String Sentenced_On, String Sentenced_Upto) {
        this.C_ID = C_ID;
        this.Criminal_Name = Criminal_Name;
        this.Crime_Type = Crime_Type;
        this.Prison_Details = Prison_Details;
        this.Sentenced_On = Sentenced_On;
        this.Sentenced_Upto = Sentenced_Upto;
    }
    
    
    
}

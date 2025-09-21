/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crms;

/**
 *
 * @author pritam
 */
public class fir_data {

   
    int F_ID ;
    String Victim_name, Suspect_names, Reported_On, Crime, Crime_Details;

    public void setF_ID(int F_ID) {
        this.F_ID = F_ID;
    }  
    

    public void setSuspect_names(String Suspect_names) {
        this.Suspect_names = Suspect_names;
    }

    public void setCrime(String Crime) {
        this.Crime = Crime;
    }

    public void setCrime_Details(String Crime_Details) {
        this.Crime_Details = Crime_Details;
    }

    public void setVictim_name(String Victim_name) {
        this.Victim_name = Victim_name;
    }

    public void setReported_On(String Reported_On) {
        this.Reported_On = Reported_On;
    }
    
    

    public int getF_ID() {
        return F_ID;
    }

    public String getVictim_name() {
        return Victim_name;
    }

    public String getSuspect_names() {
        return Suspect_names;
    }

    public String getReported_On() {
        return Reported_On;
    }

    public String getCrime() {
        return Crime;
    }

    public String getCrime_Details() {
        return Crime_Details;
    }

    public fir_data(int F_ID, String Victim_name, String Suspect_names, String Reported_On, String Crime, String Crime_Details) {
        this.F_ID = F_ID;
        this.Victim_name = Victim_name;
        this.Suspect_names = Suspect_names;
        this.Reported_On = Reported_On;
        this.Crime = Crime;
        this.Crime_Details = Crime_Details;
    }
    
   
    
}

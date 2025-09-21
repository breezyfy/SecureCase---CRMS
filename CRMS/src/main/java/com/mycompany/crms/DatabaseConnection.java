
package com.mycompany.crms;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class DatabaseConnection {
    public Connection databaseLink;
    
    public Connection getConnection(){
        String databaseName="backend";
        String databaseUser="root";
        String databasePassword="7972797102";
        String url="jdbc:mysql://localhost:3306/"+databaseName;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink=DriverManager.getConnection(url,databaseUser,databasePassword);
        }
        catch(Exception e){
            e.printStackTrace();
        }
          return databaseLink;      
    }
    
   
    
    
}

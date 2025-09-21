package com.mycompany.crms;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

        @FXML
    private Button Register_btn;

    @FXML
    private Button login_btn;

    @FXML
    private BorderPane login_page;

    @FXML
    private PasswordField pass_word;

    @FXML
    private TextField user_name;
    
    @FXML
    private Label LoginMessageLabel;
    
    public double x =0;
    public double y =0;
    public void loginbuttonOnAction(ActionEvent e){
        if (user_name.getText().isBlank()==false && pass_word.getText().isBlank()==false){
            LoginMessageLabel.setText("try to login");
            validateLogin();
        }
        else{
            LoginMessageLabel.setText("Please enter username and password.");
        }
    }
    public void validateLogin(){
    DatabaseConnection connectNow = new DatabaseConnection();
    Connection connectDB=connectNow.getConnection();
    String verifyLogin="SELECT count(1) FROM user_accounts WHERE user_name = '"+user_name.getText()+"' AND pass_word = '"+pass_word.getText()+"'";
    
    try{
        Statement statement=connectDB.createStatement();
        ResultSet queryResult = statement.executeQuery(verifyLogin);
        
        while(queryResult.next())
        {
            if(queryResult.getInt(1)==1){
            LoginMessageLabel.setText("Welcome Aboard!!");
            
            
            login_btn.getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            
            root.setOnMousePressed((MouseEvent event)->{
                x= event.getSceneX();
                y= event.getSceneY();
            });
            
            root.setOnMouseDragged((MouseEvent event)->{
                stage.setX(event.getSceneX()-x);
                stage.setY(event.getSceneY()-y);
            });
            
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            }else{
                LoginMessageLabel.setText("Login Invalid. Try Again!");
            }
        }
    }catch(Exception e){
       e.printStackTrace();
    }
    }
}


package com.mycompany.crms;

//import java.net.URL;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DashboardController implements Initializable {

    @FXML
    private Button Add_Criminal_btn;

    @FXML
    private Button Add_FIR_btn;

    @FXML
    private Button logout_btn;

    @FXML
    private Button show_FIR;

    @FXML
    private Button show_records;

    @FXML
    private StackPane dash_main;

    @FXML
    private AnchorPane CrimeRecord_page;

    @FXML
    private AnchorPane Dashboard_page;

    @FXML
    private AnchorPane addFIR_page;

    @FXML
    private Button show_dashboard;

    @FXML
    private AnchorPane addCriminal_page;

    @FXML
    private AnchorPane FIRRecord_page;

    @FXML
    private TableColumn<fir_data, Integer> F_ID;

    @FXML
    private TableView<fir_data> Fir_table;

    @FXML
    private TableColumn<fir_data, String> Reported_On;

    @FXML
    private TableColumn<fir_data, String> Suspect_names;

    @FXML
    private TableColumn<fir_data, String> Victim_name;

    @FXML
    private TableColumn<fir_data, String> Crime;

    @FXML
    private TableColumn<fir_data, String> Crime_Details;

    @FXML
    private Button AddButton_FIR;

    @FXML
    private TextField txt_CrimeDetails;

    @FXML
    private TextField txt_Suspect;

    @FXML
    private TextField txt_Victim;

    @FXML
    private TextField txt_date;

    @FXML
    private TextField txt_Crime;

    @FXML
    private TextField filterField;

    @FXML
    private TextField txt_id;
    
    @FXML
    private TextField txt_criminal_name;
    
    @FXML
    private TextField txt_SentencedOn;
    
    @FXML
    private TextField txt_SentencedUpto;
    
    @FXML
    private TextField txt_Crimetype;
    
    @FXML
    private TextField txt_prisondetails;
    
    @FXML
    private Button add_crimedata;

     @FXML
    private TableColumn<crime_data, String> Crime_Type;

    @FXML
    private TableColumn<crime_data, String> Criminal_Name;
    
    @FXML
    private TableColumn<crime_data, String> Prison_Details;
      
     @FXML
    private TextField crimetextfield;  
    
     @FXML
    private TableColumn<crime_data,String> Sentenced_On;

    @FXML
    private TableColumn<crime_data, String> Sentenced_Upto;

    @FXML
    private TableView<crime_data> crime_table;
    
    @FXML
    private TableColumn<crime_data,Integer> C_ID;

    Stage stage2;

    public void logout(ActionEvent e) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!!");
        alert.setContentText("Are you Sure ???");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage2 = (Stage) dash_main.getScene().getWindow();
            System.out.println("You have logged out!");
            stage2.close();
        }
    }

    public void switchForm(ActionEvent e) {
        if (e.getSource() == show_dashboard) {
            Dashboard_page.setVisible(true);
            CrimeRecord_page.setVisible(false);
            addFIR_page.setVisible(false);
            addCriminal_page.setVisible(false);
            FIRRecord_page.setVisible(false);
        } else if (e.getSource() == show_records) {
            Dashboard_page.setVisible(false);
            CrimeRecord_page.setVisible(true);
            addFIR_page.setVisible(false);
            addCriminal_page.setVisible(false);
            FIRRecord_page.setVisible(false);
        } else if (e.getSource() == Add_FIR_btn) {
            Dashboard_page.setVisible(false);
            CrimeRecord_page.setVisible(false);
            addFIR_page.setVisible(true);
            addCriminal_page.setVisible(false);
            FIRRecord_page.setVisible(false);
        } else if (e.getSource() == Add_Criminal_btn) {
            Dashboard_page.setVisible(false);
            CrimeRecord_page.setVisible(false);
            addFIR_page.setVisible(false);
            addCriminal_page.setVisible(true);
            FIRRecord_page.setVisible(false);
        } else if (e.getSource() == show_FIR) {
            Dashboard_page.setVisible(false);
            CrimeRecord_page.setVisible(false);
            addFIR_page.setVisible(false);
            addCriminal_page.setVisible(false);
            FIRRecord_page.setVisible(true);
        }

    }

   
    

    int index = -1;

    Connection conn = null;
    public ResultSet rs = null;
    PreparedStatement pst = null;

    public void Add_FIR() {

        conn = mysqlconnect.ConnectDb();
        String sql = "insert into fir_data (Victim_name,suspect_names,Reported_On,Crime,Crime_Details)values(?,?,?,?,? )";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_Victim.getText());
            pst.setString(2, txt_Suspect.getText());
            pst.setString(3, txt_date.getText());
            pst.setString(4, txt_Crime.getText());
            pst.setString(5, txt_CrimeDetails.getText());
            pst.execute();

            UpdateTable();
            search_ID();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
    private ObservableList<fir_data> ListM;
    public void UpdateTable() {
        F_ID.setCellValueFactory(new PropertyValueFactory<fir_data, Integer>("F_ID"));
        Victim_name.setCellValueFactory(new PropertyValueFactory<fir_data, String>("Victim_name"));
        Suspect_names.setCellValueFactory(new PropertyValueFactory<fir_data, String>("Suspect_names"));
        Reported_On.setCellValueFactory(new PropertyValueFactory<fir_data, String>("Reported_On"));
        Crime.setCellValueFactory(new PropertyValueFactory<fir_data, String>("Crime"));
        Crime_Details.setCellValueFactory(new PropertyValueFactory<fir_data, String>("Crime_Details"));
        ListM = mysqlconnect.getDatausers();
        Fir_table.setItems(ListM);

    }
    
     
     private void editData(){
    Criminal_Name.setCellFactory(TextFieldTableCell.<crime_data>forTableColumn());
    Criminal_Name.setOnEditCommit(event ->{
        crime_data person = event.getTableView().getItems().get(event.getTablePosition().getRow());
        person.setCriminal_Name(event.getNewValue());
        
    });
    Crime_Type.setCellFactory(TextFieldTableCell.<crime_data>forTableColumn());
    Crime_Type.setOnEditCommit(event ->{
        crime_data person = event.getTableView().getItems().get(event.getTablePosition().getRow());
        person.setCrime_Type(event.getNewValue());
        
    });
    Prison_Details.setCellFactory(TextFieldTableCell.<crime_data>forTableColumn());
    Prison_Details.setOnEditCommit(event ->{
        crime_data person = event.getTableView().getItems().get(event.getTablePosition().getRow());
        person.setPrison_Details(event.getNewValue());
        
    });
    Sentenced_Upto.setCellFactory(TextFieldTableCell.<crime_data>forTableColumn());
    Sentenced_Upto.setOnEditCommit(event ->{
        crime_data person = event.getTableView().getItems().get(event.getTablePosition().getRow());
        person.setSentenced_Upto(event.getNewValue());
        
    });
    
    Victim_name.setCellFactory(TextFieldTableCell.<fir_data>forTableColumn());
    Victim_name.setOnEditCommit(event ->{
        fir_data person = event.getTableView().getItems().get(event.getTablePosition().getRow());
        person.setVictim_name(event.getNewValue());
        
    });
    Suspect_names.setCellFactory(TextFieldTableCell.<fir_data>forTableColumn());
    Suspect_names.setOnEditCommit(event ->{
        fir_data person = event.getTableView().getItems().get(event.getTablePosition().getRow());
        person.setSuspect_names(event.getNewValue());
        
    });
    Crime.setCellFactory(TextFieldTableCell.<fir_data>forTableColumn());
    Crime.setOnEditCommit(event ->{
        fir_data person = event.getTableView().getItems().get(event.getTablePosition().getRow());
        person.setCrime(event.getNewValue());
        
    });
    Crime_Details.setCellFactory(TextFieldTableCell.<fir_data>forTableColumn());
    Crime_Details.setOnEditCommit(event ->{
        fir_data person = event.getTableView().getItems().get(event.getTablePosition().getRow());
        person.setCrime_Details(event.getNewValue());
        
    });
}
    

  
ObservableList<fir_data>dataList;
    @FXML
    void search_ID() {
        F_ID.setCellValueFactory(new PropertyValueFactory<fir_data, Integer>("F_ID"));
        Victim_name.setCellValueFactory(new PropertyValueFactory<fir_data, String>("Victim_name"));
        Suspect_names.setCellValueFactory(new PropertyValueFactory<fir_data, String>("Suspect_names"));
        Reported_On.setCellValueFactory(new PropertyValueFactory<fir_data, String>("Reported_On"));
        Crime.setCellValueFactory(new PropertyValueFactory<fir_data, String>("Crime"));
        Crime_Details.setCellValueFactory(new PropertyValueFactory<fir_data, String>("Crime_Details"));
        
        dataList = mysqlconnect.getDatausers();
        Fir_table.setItems(dataList);
        FilteredList<fir_data> filteredData = new FilteredList<>(dataList, b -> true);
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(fir_data -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (fir_data.getVictim_name().toLowerCase().indexOf(lowerCaseFilter) > -1) {
                    return true; 
                } else if (fir_data.getSuspect_names().toLowerCase().indexOf(lowerCaseFilter) > -1) {
                    return true; 
                } else if (fir_data.getReported_On().toLowerCase().indexOf(lowerCaseFilter) > -1) {
                    return true;
                } else if (fir_data.getCrime().indexOf(lowerCaseFilter) > -1) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<fir_data> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(Fir_table.comparatorProperty());
        Fir_table.setItems(sortedData);
    }
    
    public void Add_CR() {

        conn = mysqlconnect.ConnectDb();
        String sql = "insert into crime_data (Criminal_Name,Crime_Type,Prison_Details,Sentenced_On,Sentenced_Upto)values(?,?,?,?,? )";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_criminal_name.getText());
            pst.setString(2, txt_Crimetype.getText());
            pst.setString(3, txt_prisondetails.getText());
            pst.setString(4, txt_SentencedOn.getText());
            pst.setString(5, txt_SentencedUpto.getText());
            pst.execute();

            UpdateCrimeTable();
            search_CID();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
  
    private ObservableList<crime_data> ListC;
    public void UpdateCrimeTable() {
        C_ID.setCellValueFactory(new PropertyValueFactory<crime_data, Integer>("C_ID"));
        Criminal_Name.setCellValueFactory(new PropertyValueFactory<crime_data, String>("Criminal_Name"));
        Crime_Type.setCellValueFactory(new PropertyValueFactory<crime_data, String>("Crime_Type"));
        Prison_Details.setCellValueFactory(new PropertyValueFactory<crime_data, String>("Prison_Details"));
        Sentenced_On.setCellValueFactory(new PropertyValueFactory<crime_data, String>("Sentenced_On"));
        Sentenced_Upto.setCellValueFactory(new PropertyValueFactory<crime_data, String>("Sentenced_Upto"));
        ListC = mysqlconnect.getDataCriminals();
        crime_table.setItems(ListC);

    }
    ObservableList<crime_data>dataListC;
     @FXML
    void search_CID() {
        C_ID.setCellValueFactory(new PropertyValueFactory<crime_data, Integer>("C_ID"));
        Criminal_Name.setCellValueFactory(new PropertyValueFactory<crime_data, String>("Criminal_Name"));
        Crime_Type.setCellValueFactory(new PropertyValueFactory<crime_data, String>("Crime_Type"));
        Prison_Details.setCellValueFactory(new PropertyValueFactory<crime_data, String>("Prison_Details"));
        Sentenced_On.setCellValueFactory(new PropertyValueFactory<crime_data, String>("Sentenced_On"));
        Sentenced_Upto.setCellValueFactory(new PropertyValueFactory<crime_data, String>("Sentenced_Upto"));
        
        dataListC = mysqlconnect.getDataCriminals();
        crime_table.setItems(dataListC);
        FilteredList<crime_data> filteredData = new FilteredList<>(dataListC, b -> true);
        crimetextfield.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(crime_data -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (crime_data.getCriminal_Name().toLowerCase().indexOf(lowerCaseFilter) > -1) {
                    return true; 
                } else if (crime_data.getCrime_Type().toLowerCase().indexOf(lowerCaseFilter) > -1) {
                    return true; 
                } else if (crime_data.getPrison_Details().toLowerCase().indexOf(lowerCaseFilter) > -1) {
                    return true;
                } else if (crime_data.getSentenced_On().toLowerCase().indexOf(lowerCaseFilter) > -1) {
                    return true;
                }else if (crime_data.getSentenced_Upto().indexOf(lowerCaseFilter) > -1) {
                    return true;   
                } else {
                    return false;
                }
            });
        });

        SortedList<crime_data> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(crime_table.comparatorProperty());
        crime_table.setItems(sortedData);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          UpdateTable();
          search_ID();
          UpdateCrimeTable();
          search_CID();
          editData();
    }

}

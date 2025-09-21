module com.mycompany.crms {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.crms to javafx.fxml;
    exports com.mycompany.crms;
}

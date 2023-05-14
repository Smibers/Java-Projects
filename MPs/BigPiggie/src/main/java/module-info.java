module com.example.pig2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.BigPiggie to javafx.fxml;
    exports com.example.BigPiggie;
}
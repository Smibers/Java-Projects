module com.example.mp3_bewasmith_nhlchart {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mp3_bewasmith_nhlchart to javafx.fxml;
    exports com.example.mp3_bewasmith_nhlchart;
}
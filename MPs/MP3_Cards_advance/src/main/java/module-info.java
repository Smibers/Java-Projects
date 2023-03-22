module com.example.mp3_bewasmith_cards {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mp3_bewasmith_cards to javafx.fxml;
    exports com.example.mp3_bewasmith_cards;
}
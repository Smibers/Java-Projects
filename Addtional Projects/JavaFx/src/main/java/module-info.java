module com.example.demofxml {
	requires javafx.controls;
	requires javafx.fxml;


	opens com.example.JavaFx to javafx.fxml;
	exports com.example.JavaFx;
}
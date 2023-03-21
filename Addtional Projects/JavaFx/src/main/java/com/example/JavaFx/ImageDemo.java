package com.example.JavaFx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ImageDemo extends Application
{
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		//Image img1= new Image("https://www.wccnet.edu/_media/2023-winter-session-4-webtile.jpg");
		Image img1= new Image(getClass().getResourceAsStream("/card/2.png"));
		ImageView imageView = new ImageView(img1);

		FlowPane pane= new FlowPane();
		pane.getChildren().add(imageView);
		Scene scene = new Scene(pane,800,600);
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}

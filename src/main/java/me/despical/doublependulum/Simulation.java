package me.despical.doublependulum;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Timer;

/**
 * @author Despical
 * <p>
 * Created at 2.10.2022
 */
public class Simulation extends Application {

	static IPainter g;
	static PendSystem system;

	public static void main(String[] args){
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Double Pendulum by Despical");
		Group root = new Group();
		Scene scene = new Scene(root,1280,800, Color.WHITE);
		Canvas canvas = new Canvas(1280, 800);

		g = new GraphicsPainter(canvas.getGraphicsContext2D());
		root.getChildren().add(canvas);

		primaryStage.setScene(scene);
		primaryStage.show();

		system = new PendSystem();

		system.start();
		Timer timer = new Timer();
		timer.schedule(new Calculate(),0,500);
	}
}
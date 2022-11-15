package me.despical.doublependulum;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Despical
 * <p>
 * Created at 2.10.2022
 */
public class GraphicsPainter implements IPainter {

	private final double MASS_SIZE = 20;
	static GraphicsContext g;
	static PendSystem system;

	public GraphicsPainter(GraphicsContext g){
		GraphicsPainter.g = g;
	}

	@Override
	public void drawMass(double x, double y) {
		g.fillOval(x-MASS_SIZE/2,y-MASS_SIZE/2,MASS_SIZE,MASS_SIZE);
	}

	@Override
	public void drawRod(double x1,double y1,double x2,double y2) {
		g.strokeLine(x1, y1, x2, y2);
	}

	public void translate(double x,double y){
		g.translate(x,y);
	}

	private List<double[]> prevs = new ArrayList<>();

	public void clear(){
		translate(-640,-100);
		g.setFill(Color.WHITE);
		g.fillRect(0,0,1280,1280);

//		Simulation.g.setColor(Color.GRAY);
//		g.fillRect(0,0, 1280,100);

		Simulation.g.translate(640,100);
		Simulation.g.setColor(Color.GREEN);
		Simulation.g.drawMass(0,0);
		g.setFill(Color.BLACK);

		translate(-640, -100);

		system = Simulation.system;

		g.setFont(Font.font(25));

		g.fillText("Double Pendulum by Despical", 10, 25);
		g.fillText("Theta 1: " + system.theta1, 10, 60);
		g.fillText("Theta 2: " + system.theta2, 10, 100);
		g.fillText("Theta 1 Acceleration: " + system.theta1Acceleration, 10, 140);
		g.fillText("Theta 2 Acceleration: " + system.theta2Acceleration, 10, 180);
		g.fillText("Theta 1 Velocity: " + system.theta1Velocity, 10, 220);
		g.fillText("Theta 2 Velocity: " + system.theta2Velocity, 10, 260);

		translate(640, 100);
	}


	public void setColor(Color c){
		g.setFill(c);
	}
}
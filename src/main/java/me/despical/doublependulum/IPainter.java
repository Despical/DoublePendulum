package me.despical.doublependulum;

import javafx.scene.paint.Color;

public interface IPainter {

	void drawMass(double x, double y);

	void drawRod(double x1,double y1,double x2,double y2);

	void translate(double x,double y);

	void clear();

	void setColor(Color c);
}
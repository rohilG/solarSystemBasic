package theSolarSystem;

import java.applet.*;

import java.awt.*;

/**
 * This is the template class that manages the variables
 * @author Rohil G.
 * @date October 31, 2016
 */
public class Planet{
	
	private Graphics g;
	private int x;
	private int y;
	private java.awt.Color newColour;
	private int radius;
	private int distance;
	private int incX;

	/**
	 * Constructor method used to create new objects
	 * @param g - The object used to draw
	 * @param x_pos - The x-position of the top-left of the planet
	 * @param y_pos - The y-position of the top-left of the planet
	 */
	public Planet(Graphics g, int x_pos, int y_pos, Color Colour, int radius, int distance, int incX){
		this.x = x_pos; //sets global variable to local value
		this.y = y_pos;
		this.g = g;
		this.newColour = Colour;
		this.radius = radius;
		this.distance = distance;
		this.incX = incX;
		
		this.drawPlanet();
	}

	/**
	 * Draws a planet
	 */
	public void drawPlanet() {
		g.setColor(newColour); // set the painting color to the chosen color
		g.fillOval(x-radius/2, y-radius/2, radius, radius); // draw a filled oval with top-left at (x,y)
	}

	public void move() {
		x++;
		y++;
	}

	public void setX(int NewX) {
		this.x = NewX;
	}
	
	public void setY(int NewY) {
		this.y = NewY;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public Color getColour() {
		return newColour;
	}

	public int getRadius() {
		return radius;
	}
	
	public Graphics getG() {
		return g;
	}

	public int getDistance() {
		return distance;
	}

	public void setIncX(int i) {
		this.incX = i;
	}

	public int getIncX() {
		return incX;
	}
}






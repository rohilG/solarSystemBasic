package theSolarSystem;

import java.applet.Applet;
import java.awt.*;
import java.util.Random;
import java.lang.Math;

/**
 * This is the application class that the user uses
 * @author Rohil G. 
 * @date May 12, 2017
 */
public class mainControl extends Applet{
	//public class mainControl extends Applet implements Runnable{

	private Thread timer;	// Declare a Thread object for delay and animation
	private int length = 1400;
	private int width = 730;
	private int midx = length/2;
	private int midy = width/2;
	private int radiusOfSun = 50;
	private Planet[] data = new Planet[9];
	private int count = 0;
	
	/**
	 * This method initializes start-up values/settings sfor our applet
	 */
	public void init() {
		setSize(length, width); 	// Set the size of the applet
		setBackground(Color.BLACK); // Set the background colour
	}
	
	void sleep() { // for delay
		try {
			Thread.sleep(100);
		} 
		catch (Exception ex) {
		}
	}

	/**
	 * Draws the planet/star
	 * @param g - The object for drawing the solar system
	 */
	public void paint (Graphics g){ // main method
		
		if (count == 0){
			Planet sun = new Planet(g,midx,midy,Color.YELLOW, 50, 0, 1);
			Planet mercury = new Planet(g, midx, midy, Color.WHITE, radiusOfSun/10, 35,1);
			Planet venus = new Planet(g, midx, midy, Color.YELLOW, radiusOfSun/7, 50,1);
			Planet earth = new Planet(g, midx, midy, Color.GREEN, radiusOfSun/5, 75,1);
			Planet mars = new Planet(g, midx, midy, Color.RED, radiusOfSun/5, 100,1);
			Planet jupiter = new Planet(g, midx, midy, Color.ORANGE, radiusOfSun/3, 150,1);
			Planet saturn = new Planet(g, midx, midy, Color.ORANGE, radiusOfSun/3, 200,1);
			Planet uranus = new Planet(g, midx, midy, Color.BLUE, radiusOfSun/4, 230,1);
			Planet neptune = new Planet(g, midx, midy, Color.BLUE, radiusOfSun/4, 275,1);
			
			data[0] = sun;
			data[1] = mercury;
			data[2] = venus;
			data[3] = earth;
			data[4] = mars;
			data[5] = jupiter;
			data[6] = saturn;
			data[7] = uranus;
			data[8] = neptune;
			
			count ++;
		}
		else{
			Planet sun = new Planet(g,data[0].getX(),data[0].getY(),Color.YELLOW, 50, 0, 1);
			Planet mercury = new Planet(g, data[1].getX(),data[1].getY(), Color.WHITE, radiusOfSun/10, 25,1);
			Planet venus = new Planet(g, data[2].getX(),data[2].getY(), Color.YELLOW, radiusOfSun/7, 50,1);
			Planet earth = new Planet(g,data[3].getX(),data[3].getY(),Color.GREEN, radiusOfSun/5, 75,1);
			Planet mars = new Planet(g, data[4].getX(),data[4].getY(), Color.RED, radiusOfSun/5, 100, 1);
			Planet jupiter = new Planet(g, data[5].getX(),data[5].getY(), Color.ORANGE, radiusOfSun/3, 200,1);
			Planet saturn = new Planet(g, data[6].getX(),data[6].getY(), Color.ORANGE, radiusOfSun/3, 250,1);
			Planet uranus = new Planet(g, data[7].getX(),data[7].getY(), Color.BLUE, radiusOfSun/4, 325,1);
			Planet neptune = new Planet(g, data[8].getX(),data[8].getY(), Color.BLUE, radiusOfSun/4, 400,1);
			
			data[1].drawPlanet();
			
			circularMotion(data[1]);
			circularMotion(data[2]);
			circularMotion(data[3]);
			circularMotion(data[4]);
			circularMotion(data[5]);
			circularMotion(data[6]);
			circularMotion(data[7]);
			circularMotion(data[8]);
		}
		
		sleep();
		repaint();

	}

	private void circularMotion(Planet planet) {
		if (planet.getX() == (midx + planet.getDistance())){
			planet.setIncX(-1);
		}
		else if (planet.getX() == (midx - planet.getDistance())){
			planet.setIncX(1);
		} 
		
		planet.setX(planet.getX() + planet.getIncX());		
		planet.setY(midy + findY(planet));
	}

	private int findY(Planet planet) {
		int radius = planet.getDistance();
		int x = planet.getX() -midx;
		int y = (int) Math.sqrt(Math.pow(radius, 2) - Math.pow(x, 2));
		
		if (planet.getIncX() > 0){
			return y;
		}
		else{
			return -y;
		}
		
	}
}
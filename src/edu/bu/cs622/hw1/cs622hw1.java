package edu.bu.cs622.hw1;

public class cs622hw1 {
	
	// Game object handles the environment
	public class Game {
		// private fields
		private Weather weather;
		private Gorilla player1;
		private Gorilla player2;
		
		public Game(Weather weather, Gorilla player1, Gorilla player2) {
			this.weather = weather;
			this.player1 = player1;
			this.player2 = player2;
		}
				
		public void draw() {
			// set up canvas and display game objects
			// also keeps track of states of different characters
		}
	}
	
	// weather handles the wind
	public class Weather {
		private int windDirection;
		private double windSpeed;
		
		public Weather(int windDirection, double windSpeed) {
			this.windDirection = windDirection;
			this.windSpeed = windSpeed;
		}
		
		// overloaded constructors
		public Weather(int windDirection) {
			this(windDirection, 1.0);
		}
		
		public Weather() {
			this(0, 1.0);
		}
	}
		
	public class Character {
		// private fields 
		private int height;
		private int width;
		private double xPos;
		private double yPos;
		
		// constructor
		public Character(int height, int width, double xPos, double yPos) {
			this.height = height;
			this.width = width;
			this.xPos = xPos;
			this.yPos = yPos;
		}
		
		// handles when character moves itself
		public void move(int direction, double speed) {
			// move at speed towards direction 
		}
		
		// method overloading with fewer parameters
		public void move(int direction) {
			// default speed is 1.0
			move(direction, 1.0);
		}
		
		public void die() {
			// handles destruction of a character
		}
		
		// getters and setters
		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public double getxPos() {
			return xPos;
		}

		public void setxPos(double xPos) {
			this.xPos = xPos;
		}

		public double getyPos() {
			return yPos;
		}

		public void setyPos(double yPos) {
			this.yPos = yPos;
		}	
	}
	
	public class Gorilla extends Character implements shooter {
		// each player object tracks score of the player
		private int score = 0;
		
		// constructor
		public Gorilla(int height, int width, double xPos, double yPos, int score) {
			super(height, width, xPos, yPos);
			this.score = score;
		}
		
		// getters and setters for private field
		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
		
		// implements interface shoot
		public void shoot(double angle, double velocity) {
			// shoot at given angle and velocity
		}
		
		// overloaded shoot method that uses initial values
		public void shoot() {}
		
		// override parent method
		public void die() {
			// handles events when one player loses
		}
	}
	
	public class Banana extends Character{
		// uses all the same fields as parent class
		private Banana(int height, int width, double xPos, double yPos) {
			super(height, width, xPos, yPos);
		}
		
		// overrides die() method from parent method
		public void die() {
			// handles events when bananas land and hit or miss targets
		}
	}
	
	public class Building extends Character{
		// private fields
		private String color;
		
		private Building(int height, int width, double xPos, double yPos, String color) {
			super(height, width, xPos, yPos);
			this.color = color;
		}
		
		// getter and setter
		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
	}
	
	public interface shooter {
		// default shooting angle and velocity
		double angle = 45; // in degrees, ranging from 0 - 180
		double velocity = 1.0;
		
		void shoot();
	}

	// main method, test client
	public static void main(String[] args) {
		System.out.println("Welcome to the Gorilla Game.");
	}

}

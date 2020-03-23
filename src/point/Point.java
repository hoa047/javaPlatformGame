package src.point;

/**
 * A moveable point with x,y coordinates and direction
 * @author Hoa Truong
 *
 */
public class Point {
	private int xCoordinate;
	private int yCoordinate;
	private int degrees;	// The point's direction measured in degrees. 
							// 0 is North, 12 o'clock and up
	
	/**
	 * Create a point with starting position and direction
	 * @param x the point's x-coordinate
	 * @param y the point's y-coordinate
	 * @param degrees direction in degrees
	 */
	public Point(int xCoordinate, int yCoordinate, int degrees) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.degrees = degrees;
	}
	
	/**
	 * Move the point a number of steps
	 * @param steps the number of steps to be moved
	 */
	public void move(int steps) {
		if(degrees%360 == 0) {
			move(0, -steps);
		} else if(degrees%360 == 90 || 
				degrees%360 == -270) {
			move(steps, 0);
		} else if(degrees%360 == 180 || 
				degrees%360 == -180) {
			move(0, steps);
		} else if(degrees%360 == 270 || 
				degrees%360 == -90) {
			move(-steps, 0);			
		}
	}
	
	/**
	 * Get the point's x-coordinate
	 * @return the point's x-coordinate
	 */	
	public int getX() {
		return xCoordinate;
	}

	/**
	 * Get the point's y-coordinate
	 * @return the point's y-coordinate
	 */
	public int getY() {
		return yCoordinate;
	} 

	/**
	 * Rotate the point a number of degrees
	 * @param degrees number of degrees to rotate the point
	 */
	public void rotate(int degrees) {
		this.degrees += degrees;
	}

	/**
	 * Return a string representation of the point's position and direction
	 * @return the point's position and direction
	 */
	public String toString() {
		return "[" + xCoordinate + ", " + yCoordinate + "] pointing at " + degrees +" degrees";
	}

	/**
	 * Return a string representation of the point's position
	 * @return the point's position
	 */
	public String getPositionAsString() {
		return "[" + xCoordinate + ", " + yCoordinate + "]";
	}

	
	private void move(int xUnits, int yUnits) {
		xCoordinate += xUnits;
		yCoordinate += yUnits;
	}

}

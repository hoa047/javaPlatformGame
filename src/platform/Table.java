package src.platform;

/**
 * Table implementation of a platform
 * @author Hoa Truong
 *
 */
public class Table implements Platform {
	private int xBoundary;
	private int yBoundary;
	
	/**
	 * Create a table with with a given size
	 * @param xBoundary horizontal size of the table
	 * @param yBoundary vertical size of the table
	 */
	public Table(int xBoundary, int yBoundary) {
		this.xBoundary = xBoundary;
		this.yBoundary = yBoundary;
	}
	
	/**
	 * Checks if the coordinates are within the platform's boundaries
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 * @return if the coordinates are within the platform's boundaries
	 */
	public boolean stillOnPlatform(int x, int y) {		
		return !(x < 0 || 
		   y < 0 ||
		   xBoundary - x < 0 || 
		   yBoundary - y < 0);
	}
	
	/**
	 * Returns a string representation of the platform's size
	 * @return the platform's size
	 */
	public String toString() {
		return "[" + xBoundary + ", " + yBoundary + "]";
	}
}

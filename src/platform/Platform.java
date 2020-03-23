package src.platform;

/**
 * Interface for a platform
 * @author Hoa Truong
 *
 */
public interface Platform {
	
	/**
	 * Checks if the coordinates are within the platform's boundaries
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 * @return if the coordinates are within the platform's boundaries
	 */
	public boolean stillOnPlatform(int x, int y);	

	/**
	 * Returns a string representation of the platform's size
	 * @return the platform's size
	 */
	public String toString();
}

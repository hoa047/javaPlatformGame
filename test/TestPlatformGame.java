package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.platform.Platform;
import src.platform.Table;
import src.point.Point;

/**
 * Test class for platformGame
 * 
 * @author Hoa Truong
 */
public class TestPlatformGame {
	private Platform platform;
	private Point point;
	private int[] stdIn;

	@Test
	public void testOnPlatformQuit() {
		stdIn = new int[]{4,4,2,2,1,4,1,3,2,3,2,4,1,0};
		platform = new Table(stdIn[0], stdIn[1]);
		point = new Point(stdIn[2], stdIn[3], 0);
		String position = runTest(stdIn, platform, point);
		assertTrue(position.equals("[0, 1]"));
	}

	@Test
	public void testFallOfPlatform() {
		stdIn = new int[]{4,4,2,2,1,1,1};
		platform = new Table(stdIn[0], stdIn[1]);
		point = new Point(stdIn[2], stdIn[3], 0);
		String position = runTest(stdIn, platform, point);
		assertTrue(position.equals("[-1, -1]"));
	}
	
	private String runTest(int[] stdIn, Platform platform, Point point) {
		String position = "[-1, -1]";
		for (int i = 4; i < stdIn.length; i++) {
			if(stdIn[i] == 0) {
				position = point.getPositionAsString();
				break;
			} else if(stdIn[i] == 1) {
				point.move(1);
				if(!platform.stillOnPlatform(point.getX(), point.getY())) {
					break;
				}
			} else if(stdIn[i] == 2) {
				point.move(-1);
				if(!platform.stillOnPlatform(point.getX(), point.getY())) {
					break;
				}
			} else if(stdIn[i] == 3) {
				point.rotate(90);
			} else if(stdIn[i] == 4) {
				point.rotate(-90);
			}
		}
		return position;
	}
}

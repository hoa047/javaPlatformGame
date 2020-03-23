package src.platformGame;

import java.util.Scanner;
import src.platform.Platform;
import src.platform.Table;
import src.platformGameUtils.LoggingUtils;
import src.platformGameUtils.PrintUtils;
import src.point.Point;

public class Main {
	private static Point point;
	private static Platform platform;
	
	public static void main(String[] args) {
		boolean log = LoggingUtils.loggingEnabled(args);
		Scanner sc = new Scanner(System.in);
		// Setup the platform and point
		setupGame(log, sc);
		
		//Play until game over
		String finalPosition = playGame(log, sc);
		
		//Game over
		PrintUtils.printGameResult(log, finalPosition);
		sc.close();
	}	
	
	private static void setupGame(boolean log, Scanner sc) {
		if (log) {
			System.out.println("Specify dimensions 1st, 2st and starting position 3rd, 4th");
		}
		int[] initialHeader = new int[4];
		for (int i = 0; i < 4; i++) {
			initialHeader[i] = sc.nextInt();
		}
		point = new Point(initialHeader[2], initialHeader[3], 0);
		platform = new Table(initialHeader[0], initialHeader[1]);
		if (log) {
			System.out.println("Platform size: " + platform.toString());
			System.out.println("Starting position: " + point.toString());
			System.out.println("Setup done. Start game!");
		}
	}
	
	private static String playGame(boolean log, Scanner sc) {
		int command = 0;
		boolean play = true;
		while(play) {
			command = sc.nextInt();
			if(command == 0) {
				play = false;
				return point.getPositionAsString();
			} else if(command == 1) {
				point.move(1);
				play = platform.stillOnPlatform(point.getX(), point.getY());
			} else if(command == 2) {
				point.move(-1);
				play = platform.stillOnPlatform(point.getX(), point.getY());
			} else if(command == 3) {
				point.rotate(90);
			} else if(command == 4) {
				point.rotate(-90);
			}
			if(log) {
				System.out.println("Platform: " + platform.toString() + " / Point: " + point.toString());
			}
		}
		return "[-1, -1]";
	}
}

package src.platformGameUtils;

public class PrintUtils {
	public static void printGameResult(boolean log, String finalPosition) {
		if (log) {
			System.out.println("Result......................");
		}
		System.out.println(finalPosition);
	}
}

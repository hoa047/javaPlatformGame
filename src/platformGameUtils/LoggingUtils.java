package src.platformGameUtils;

public class LoggingUtils {
	public static boolean loggingEnabled(String[] args) {
		return (args.length > 0 && args[0].equals("log"));
	}
}

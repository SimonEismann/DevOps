package setup;

public class Logs {

	public static void collectLogs() throws InterruptedException {
		Thread.sleep(20000);
		Util.getFile("10.1.3.48", "Setup/result_gcp.csv");
	}

}

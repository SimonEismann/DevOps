package setup;

public class Logs {

	public static void collectLogs(long experimentStart, long experimentEnd) throws InterruptedException {
		Thread.sleep(20000);
		Util.getFile("10.1.3.48", "Setup/result_gcp.csv");
		String utilLogs = Util.sendCommandWithReturn("10.1.3.48", "curl -X GET -H \"Authorization: Bearer ya29.GlsrBq7r4CIjBS4F7AuwszUKjTfp_cioF7CJIsiWwmCS7zvUi3djP97yz0YKMQi1mb9opOcUseJ9yRDeMCoD0Rzn9DT6EQPlj1CFn5fLK6U4JfZon4PS2_UEN2Tk\" \"https://monitoring.googleapis.com/v3/projects/devops-218113/timeSeries?filter=metric.type%3D%22compute.googleapis.com%2Finstance%2Fcpu%2Futilization%22&interval.endTime=2018-10-02T12%3A34%3A56.992Z&interval.startTime=2018-09-02T12%3A34%3A56.992Z\"");
		System.out.println(utilLogs);
	}

}

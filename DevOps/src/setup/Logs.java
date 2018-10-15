package setup;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Logs {
	static DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
            .withZone(ZoneId.of("UTC"));

	public static void collectLogs(long experimentStart, String expName) throws InterruptedException, IOException {
		long experimentEnd = experimentStart + 5 * 60000;
		Thread.sleep(180000);
		Util.getFile("10.1.3.48", "Setup/result_gcp.csv");
		Util.getFile("10.1.3.48", "timestamps.csv");
		String startTime = formatter.format(new Date(experimentStart).toInstant());
		String endTime = formatter.format(new Date(experimentEnd).toInstant());
		System.out.println(startTime);
		System.out.println(endTime);
		String token = Util.sendCommandWithReturn("10.1.3.48", "gcloud auth application-default print-access-token ").trim();
		String utilLogs = Util.sendCommandWithReturn("10.1.3.48", "curl -X GET -H \"Authorization: Bearer " + token + "\" \"https://monitoring.googleapis.com/v3/projects/devops-218113/timeSeries?filter=metric.type%3D%22compute.googleapis.com%2Finstance%2Fcpu%2Futilization%22&interval.endTime=" + endTime + "&interval.startTime=" + startTime + "\"");
		System.out.println(utilLogs);
		try (PrintWriter out = new PrintWriter("utilization.json")) {
		    out.println(utilLogs);
			out.close();
		}
		new File("/" +expName + "/test.csv").mkdirs();
		Files.move(Paths.get("result_gcp.csv"), Paths.get("/" + expName + "/result_gcp.csv"), StandardCopyOption.REPLACE_EXISTING);
		Files.move(Paths.get("timestamps.csv"), Paths.get("/" + expName + "/timestamps.csv"), StandardCopyOption.REPLACE_EXISTING);
		Files.move(Paths.get("utilization.json"), Paths.get("/" + expName + "/utilization.json"), StandardCopyOption.REPLACE_EXISTING);
	}

}
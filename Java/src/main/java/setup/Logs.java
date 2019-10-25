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
	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
			.withZone(ZoneId.of("UTC"));

	public static void collectLogs(long experimentStart, String expName) throws InterruptedException, IOException {
		long experimentEnd = experimentStart + 5 * 60000;
		String deployment = Util.executeCommands(new String[] {
				"kubectl get pod -o=custom-columns=NAME:.metadata.name,STATUS:.status.phase,NODE:.spec.nodeName -n default" },
				true);
		File f = new File("deployment.txt");
		f.createNewFile();
		try (PrintWriter out = new PrintWriter("deployment.txt")) {
			out.println(deployment);
			out.close();
		}
		Thread.sleep(180000);
		// Util.getFile("10.1.3.32", "Setup/result_gcp.csv");
		// Util.getFile("10.1.3.32", "timestamps.csv");
		// Util.sendCommand("10.1.227.75", "mv timestamps.csv timestamps2.csv");
		// Util.getFile("10.1.227.75", "timestamps2.csv");
		String startTime = formatter.format(new Date(experimentStart).toInstant());
		String endTime = formatter.format(new Date(experimentEnd).toInstant());
		String token = Util
				.executeCommands(new String[] { "gcloud auth application-default print-access-token " }, true).trim();
		String utilLogs = Util.executeCommands(new String[] { "curl -X GET -H \"Authorization: Bearer " + token
				+ "\" \"https://monitoring.googleapis.com/v3/projects/microservice-perf-regr/timeSeries?filter=metric.type%3D%22compute.googleapis.com%2Finstance%2Fcpu%2Futilization%22&interval.endTime="
				+ endTime + "&interval.startTime=" + startTime + "\"" }, true);
		try (PrintWriter out = new PrintWriter("utilization.json")) {
			out.println(utilLogs);
			out.close();
		}
		new File(expName + "/").mkdirs();
		Files.move(Paths.get("deployment.txt"), Paths.get(expName + "/deployment.txt"),
				StandardCopyOption.REPLACE_EXISTING);
		Files.move(Paths.get("result_gcp.csv"), Paths.get(expName + "/result_gcp.csv"),
				StandardCopyOption.REPLACE_EXISTING);
		Files.move(Paths.get("timestamps.csv"), Paths.get(expName + "/timestamps.csv"),
				StandardCopyOption.REPLACE_EXISTING);
		Files.move(Paths.get("timestamps2.csv"), Paths.get(expName + "/timestamps2.csv"),
				StandardCopyOption.REPLACE_EXISTING);
		Files.move(Paths.get("utilization.json"), Paths.get(expName + "/utilization.json"),
				StandardCopyOption.REPLACE_EXISTING);
	}

}
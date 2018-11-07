package setup;

public class Load {

	public static long browse(LoadLevel loadLevel, boolean useC42) throws InterruptedException {
		Util.sendCommand("10.1.3.48", "sed -i 's/myplaceholder/http:\\/\\/" + Setup.webuiIp + "/g' Setup/browse.lua");
		Util.sendCommandBackground("10.1.3.48", "pkill -f 'java -jar'");
		Util.sendCommandBackground("10.1.3.48", "java -jar Setup/httploadgenerator.jar loadgenerator");
		if (useC42) {
			Util.sendCommandBackground("10.1.3.42", "pkill -f 'java -jar'");
			Util.sendCommandBackground("10.1.3.42", "java -jar httploadgenerator.jar loadgenerator");
		}
		Thread.sleep(3000);
		String loadDriverLogs = Util.sendCommandWithReturnAndLogs("10.1.3.48",
				"cd Setup/ && java -jar httploadgenerator.jar director -s 127.0.0.1" + ((useC42)? ",10.1.3.42":"") + " -a ./"
						+ loadLevel.fileName
						+ " -l ./browse.lua -o ./result_gcp.csv -p test --randomize-users --wd 1200 --wp 30 --wr "
						+ Math.floor((double) loadLevel.loadLevel / ((useC42)? 2:1)) + " -u 5000");
		String timestamp = loadDriverLogs.substring(loadDriverLogs.lastIndexOf("@") + 1, loadDriverLogs.lastIndexOf("@") + 14);
		return Long.parseLong(timestamp);
	}
}
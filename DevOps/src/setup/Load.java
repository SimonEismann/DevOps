package setup;

public class Load {

	public static long browse(LoadLevel loadLevel) throws InterruptedException {
		Util.sendCommand("10.1.3.48", "sed -i 's/myplaceholder/http:\\/\\/" + Setup.webuiIp + "/g' Setup/browse.lua");
		Util.sendCommandBackground("10.1.3.48", "pkill -f 'java -jar'");
		Util.sendCommandBackground("10.1.3.48", "java -jar Setup/httploadgenerator.jar loadgenerator");
		Util.sendCommandBackground("10.1.3.49", "pkill -f 'java -jar'");
		Util.sendCommandBackground("10.1.3.49", "java -jar httploadgenerator.jar loadgenerator");
		Thread.sleep(3000);
		String loadDriverLogs = Util.sendCommandWithReturnAndLogs("10.1.3.48",
				"cd Setup/ && java -jar httploadgenerator.jar director -s 127.0.0.1,10.1.3.49 -a ./"
						+ loadLevel.fileName
						+ " -l ./browse.lua -o ./result_gcp.csv -p test --randomize-users --wd 180 --wp 10 --wr "
						+ Math.floor((double) loadLevel.loadLevel / 2) + " -u 5000");
		String timestamp = loadDriverLogs.substring(loadDriverLogs.lastIndexOf("@") + 1, loadDriverLogs.lastIndexOf("@") + 14);
		System.out.println(timestamp);
		return Long.parseLong(timestamp);
	}
}
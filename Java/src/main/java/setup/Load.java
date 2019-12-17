package setup;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Load {

	public static long browse(LoadLevel loadLevel) throws InterruptedException {
		Util.executeCommands(new String[] {"sed -i 's/myplaceholder/http:\\/\\/" + Setup.webuiIp + "/g' /browse.lua"}, false);
		String ip1 = Util.executeCommands(new String[] {
		"gcloud compute instances describe loaddriver1 --zone europe-west3-a --format='get(networkInterfaces[0].accessConfigs[0].natIP)'" }, true).trim();
		System.out.println(ip1);
		String ip2 = Util.executeCommands(new String[] {
				"gcloud compute instances describe loaddriver2 --zone europe-west3-a --format='get(networkInterfaces[0].accessConfigs[0].natIP)'" }, true).trim();
		System.out.println(ip2);
		String ip3 = Util.executeCommands(new String[] {
				"gcloud compute instances describe loaddriver3 --zone europe-west3-a --format='get(networkInterfaces[0].accessConfigs[0].natIP)'" }, true).trim();
		System.out.println(ip3);
		System.out.println("STARTING EXPERIMENT - THIS WILL TAKE ~35 MINUTES");
		System.out.println("java -jar httploadgenerator.jar director -s " + ip1 + "," + ip2 + "," + ip3 + " -a ./"
						+ loadLevel.fileName
						+ " -l ./browse.lua -o ./result_gcp.csv -p test --randomize-users --wd 1200 --wp 30 --wr "
						+ Math.floor((double) loadLevel.loadLevel / 3) + " -u 5000 2>&1 | tee outfile.txt");
		Util.executeCommands(new String[] { "java -jar httploadgenerator.jar director -s " + ip1 + "," + ip2 + "," + ip3 + " -a ./"
						+ loadLevel.fileName
						+ " -l ./browse.lua -o ./result_gcp.csv -p test --randomize-users --wd 1200 --wp 30 --wr "
						+ Math.floor((double) loadLevel.loadLevel / 3) + " -u 5000 2>&1 | tee outfile.txt" }, false);
		String loadDriverLogs = readAllBytesJava7("outfile.txt");
		System.out.println(loadDriverLogs);
		String timestamp = loadDriverLogs.substring(loadDriverLogs.lastIndexOf("@") + 1,
				loadDriverLogs.lastIndexOf("@") + 14);
		return Long.parseLong(timestamp);
	}    
	
	private static String readAllBytesJava7(String filePath) {
        String content = "";
 
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
 
        return content;
    }
}
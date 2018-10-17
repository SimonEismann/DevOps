package experiment;

import java.io.IOException;

import setup.Load;
import setup.LoadLevel;
import setup.Logs;
import setup.Setup;

public class FivePools {

	public static void main(String[] args) throws InterruptedException, IOException {
		 System.err.println("SETUP");
		 Setup.setup5Pools();
		 
		 System.err.println("WARMUP");
		 Load.browse(LoadLevel.LOAD100, true);
		 Thread.sleep(600000);
		 Load.browse(LoadLevel.LOAD100, true);
		 Thread.sleep(1800000);

		 System.err.println("EXPERIMENT");
		 long expStart = Load.browse(LoadLevel.LOAD100, true);
		 
		 System.err.println("COLLECTING LOGS");
		 Logs.collectLogs(expStart, "5Pools-150Load");

		 System.err.println("SHUTTING DOWN");
		 Setup.teardown();
		 
		 System.err.println("FINISHED");
		 System.exit(0);
	}
}

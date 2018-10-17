package experiment;

import java.io.IOException;

import setup.Load;
import setup.LoadLevel;
import setup.Logs;
import setup.Setup;

public class OneCore {

	public static void main(String[] args) throws InterruptedException, IOException {
		 System.err.println("SETUP");
		 Setup.setup1Core();
		 
		 System.err.println("WARMUP");
		 Load.browse(LoadLevel.LOAD450, true);
		 Thread.sleep(600000);
		 Load.browse(LoadLevel.LOAD450, true);
		 Thread.sleep(1800000);

		 System.err.println("EXPERIMENT");
		 long expStart = Load.browse(LoadLevel.LOAD450, true);
		 
		 System.err.println("COLLECTING LOGS");
		 Logs.collectLogs(expStart, "1Core-450Load");

		 System.err.println("SHUTTING DOWN");
		 Setup.teardown();
		 
		 System.err.println("FINISHED");
		 System.exit(0);
	}
}

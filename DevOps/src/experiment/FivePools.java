package experiment;

import java.io.FileNotFoundException;

import setup.Load;
import setup.LoadLevel;
import setup.Logs;
import setup.Setup;

public class FivePools {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		 System.out.println("SETUP");
		 Setup.setup5Pools();
		 
		 System.out.println("WARMUP");
		 Load.browse(LoadLevel.LOAD150);
		 Thread.sleep(300000);

		 System.out.println("EXPERIMENT");
		 long expStart = Load.browse(LoadLevel.LOAD150);
		 
		 System.out.println("COLLECTING LOGS");
		 Logs.collectLogs(expStart);

		 System.out.println("SHUTTING DOWN");
		 Setup.teardown();
		 
		 System.out.println("FINISHED");
		 System.exit(0);
	}
}

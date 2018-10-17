package experiment;

import java.io.FileNotFoundException;
import java.io.IOException;

import setup.Load;
import setup.LoadLevel;
import setup.Logs;
import setup.Setup;

public class Playground {
	
	public static void main(String[] args) throws InterruptedException, IOException {
//		 System.err.println("SETUP");
//		 Setup.setup5Pools();
		 
//		 System.err.println("WARMUP");
//		 Load.browse(LoadLevel.LOAD150);
//		 Thread.sleep(300000);

		 System.err.println("EXPERIMENT");
		 long expStart = Load.browse(LoadLevel.LOAD150, false); 
		
		 System.err.println("COLLECTING LOGS");
		 Logs.collectLogs(expStart, "PlayGround");

//		 System.err.println("SHUTTING DOWN");
//		 Setup.teardown();
		 
		 System.err.println("FINISHED");
		 System.exit(0);
	}

}

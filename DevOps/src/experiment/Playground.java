package experiment;

import java.io.FileNotFoundException;
import java.io.IOException;

import setup.Load;
import setup.LoadLevel;
import setup.Logs;
import setup.Setup;

public class Playground {
	
	public static void main(String[] args) throws InterruptedException, IOException {
//		 System.out.println("SETUP");
//		 Setup.setup5Pools();
		 
//		 System.out.println("WARMUP");
//		 Load.browse(LoadLevel.LOAD150);
//		 Thread.sleep(300000);

		 System.out.println("EXPERIMENT");
		 long expStart = Load.browse(LoadLevel.LOAD150, false); 
		
		 System.out.println("COLLECTING LOGS");
		 Logs.collectLogs(expStart, "PlayGround");

//		 System.out.println("SHUTTING DOWN");
//		 Setup.teardown();
		 
		 System.out.println("FINISHED");
		 System.exit(0);
	}

}

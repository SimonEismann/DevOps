package experiments;

import setup.Load;
import setup.LoadLevel;
import setup.Logs;

public class Playground {

	public static void main(String[] args) throws InterruptedException {
//		 System.out.println("SETUP");
//		 Setup.setup5Pools();
		 
//		 System.out.println("WARMUP");
//		 Load.browse(LoadLevel.LOAD150);
//		 Thread.sleep(300000);

		 System.out.println("EXPERIMENT");
		 Load.browse(LoadLevel.LOAD150);
		 
		 System.out.println("COLLECTING LOGS");
		 Logs.collectLogs();

//		 System.out.println("SHUTTING DOWN");
//		 Setup.teardown();
		 
		 System.out.println("FINISHED");
		 System.exit(0);
	}

}

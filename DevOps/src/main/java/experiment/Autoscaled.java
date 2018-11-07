package experiment;

import java.io.IOException;

import setup.Load;
import setup.LoadLevel;
import setup.Logs;
import setup.Setup;

public class Autoscaled {

	public static void performExperiment(LoadLevel loadLevel, String expName) throws InterruptedException, IOException {
		System.err.println("SETUP");
		Setup.setupAutoscaled();
		Thread.sleep(60000);
		
		System.err.println("EXPERIMENT");
		long expStart = Load.browse(loadLevel, true);

		System.err.println("COLLECTING LOGS");
		Logs.collectLogs(expStart, expName);

		System.err.println("SHUTTING DOWN");
		Setup.teardown();

		System.err.println("FINISHED");
	}
}
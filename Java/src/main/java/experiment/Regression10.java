package experiment;

import java.io.IOException;

import setup.Load;
import setup.LoadLevel;
import setup.Logs;
import setup.Setup;

public class Regression10 {

	public static void performExperiment(LoadLevel loadLevel, int expNumber) throws InterruptedException, IOException {
		System.err.println("SETUP");
		Setup.setupRegression10();
		Thread.sleep(60000);

		System.err.println("EXPERIMENT");
		long expStart = Load.browse(loadLevel);

		System.err.println("COLLECTING LOGS");
		Logs.collectLogs(expStart, "Regression10-" + loadLevel.loadLevel + "Load-" + expNumber);

		System.err.println("SHUTTING DOWN");
		Setup.teardownRegression10();

		System.err.println("FINISHED");
	}
}

package experiment;

import java.io.IOException;

import setup.Load;
import setup.LoadLevel;
import setup.Logs;
import setup.Setup;

public class Regression {

	public static void performExperiment(LoadLevel loadLevel, int expNumber) throws InterruptedException, IOException {
		System.err.println("SETUP");
		Setup.setupRegression();
		Thread.sleep(60000);

		System.err.println("EXPERIMENT");
		long expStart = Load.browse(loadLevel, true);

		System.err.println("COLLECTING LOGS");
		Logs.collectLogs(expStart, "Regression-" + loadLevel.loadLevel + "Load-" + expNumber);

		System.err.println("SHUTTING DOWN");
		Setup.teardown();

		System.err.println("FINISHED");
	}
}

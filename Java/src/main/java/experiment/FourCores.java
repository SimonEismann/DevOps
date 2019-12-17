package experiment;

import java.io.IOException;

import setup.Load;
import setup.LoadLevel;
import setup.Logs;
import setup.Setup;

public class FourCores {

	public static void performExperiment(LoadLevel loadLevel, int expNumber) throws InterruptedException, IOException {
		System.err.println("SETUP");
		Setup.setup4Cores();
		Thread.sleep(60000);

		System.err.println("EXPERIMENT");
		long expStart = Load.browse(loadLevel);

		System.err.println("COLLECTING LOGS");
		Logs.collectLogs(expStart, "4Cores-" + loadLevel.loadLevel + "Load-" + expNumber);

		System.err.println("SHUTTING DOWN");
		Setup.teardown4Cores();

		System.err.println("FINISHED");
	}
}

package experiment;

import java.io.IOException;

import setup.Load;
import setup.LoadLevel;
import setup.Logs;
import setup.Setup;

public class OneCore {

	public static void performExperiment(LoadLevel loadLevel) throws InterruptedException, IOException {
		System.err.println("SETUP");
		Setup.setup1Core();

		System.err.println("WARMUP");
		Load.browse(loadLevel, true);
		Thread.sleep(60000);
		Load.browse(loadLevel, true);
		Thread.sleep(180000);

		System.err.println("EXPERIMENT");
		long expStart = Load.browse(loadLevel, true);

		System.err.println("COLLECTING LOGS");
		Logs.collectLogs(expStart, "1Core-" + loadLevel.loadLevel + "Load");

		System.err.println("SHUTTING DOWN");
		Setup.teardown();

		System.err.println("FINISHED");
		System.exit(0);
	}
}
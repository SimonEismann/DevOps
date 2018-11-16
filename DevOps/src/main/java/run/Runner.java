package run;

import java.io.IOException;

import experiment.Autoscaled;
import experiment.Balanced;
import experiment.FourCores;
import experiment.OneCore;
import setup.LoadLevel;

public class Runner {

	public static void main(String[] args) throws InterruptedException, IOException {
		for (int i = 6; i <= 10; i++)  {
			Balanced.performExperiment(LoadLevel.LOAD700, "Balanced-700Load-" + i);
			Autoscaled.performExperiment(LoadLevel.LOAD700, "Autoscaled-700Load-" + i);
			OneCore.performExperiment(LoadLevel.LOAD700, "1Core-700Load-" + i);
			FourCores.performExperiment(LoadLevel.LOAD700, "4Cores-700Load-" + i);

			Balanced.performExperiment(LoadLevel.LOAD800, "Balanced-800Load-" + i);
			Autoscaled.performExperiment(LoadLevel.LOAD800, "Autoscaled-800Load-" + i);
			OneCore.performExperiment(LoadLevel.LOAD800, "1Core-800Load-" + i);
			FourCores.performExperiment(LoadLevel.LOAD800, "4Cores-800Load-" + i);

			Balanced.performExperiment(LoadLevel.LOAD800, "Balanced-800Load-" + i);
			Autoscaled.performExperiment(LoadLevel.LOAD900, "Autoscaled-900Load-" + i);
			OneCore.performExperiment(LoadLevel.LOAD900, "1Core-900Load-" + i);
			FourCores.performExperiment(LoadLevel.LOAD900, "4Cores-900Load-" + i);
		}
		System.exit(0);
	}
	
}
package run;

import java.io.IOException;

import experiment.Autoscaled;
import experiment.Balanced;
import experiment.FourCores;
import experiment.OneCore;
import setup.LoadLevel;

public class Runner {

	public static void main(String[] args) throws InterruptedException, IOException {
		Balanced.performExperiment(LoadLevel.LOAD700);
		Autoscaled.performExperiment(LoadLevel.LOAD700);
		OneCore.performExperiment(LoadLevel.LOAD700);
		FourCores.performExperiment(LoadLevel.LOAD700);

		Balanced.performExperiment(LoadLevel.LOAD800);
		Autoscaled.performExperiment(LoadLevel.LOAD800);
		OneCore.performExperiment(LoadLevel.LOAD800);
		FourCores.performExperiment(LoadLevel.LOAD800);

		Balanced.performExperiment(LoadLevel.LOAD900);
		Autoscaled.performExperiment(LoadLevel.LOAD900);
		OneCore.performExperiment(LoadLevel.LOAD900);
		FourCores.performExperiment(LoadLevel.LOAD900);
		
		System.exit(0);
	}
	
}
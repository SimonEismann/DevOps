package run;

import java.io.IOException;

import experiment.Autoscaled;
import experiment.Balanced;
import experiment.FourCores;
import experiment.OneCore;
import experiment.Regression10;
import experiment.Regression30;
import setup.LoadLevel;

public class Runner {

	public static void main(String[] args) throws InterruptedException, IOException {
		for (int i = 1; i <= 10; i++) {
			Regression10.performExperiment(LoadLevel.LOAD700, i);
			Regression10.performExperiment(LoadLevel.LOAD800, i);
			Regression10.performExperiment(LoadLevel.LOAD900, i);
			Regression30.performExperiment(LoadLevel.LOAD700, i);
			Regression30.performExperiment(LoadLevel.LOAD800, i);
			Regression30.performExperiment(LoadLevel.LOAD900, i);
			OneCore.performExperiment(LoadLevel.LOAD700, i);
			OneCore.performExperiment(LoadLevel.LOAD800, i);
			OneCore.performExperiment(LoadLevel.LOAD900, i);
			Balanced.performExperiment(LoadLevel.LOAD700, i);
			Balanced.performExperiment(LoadLevel.LOAD800, i);
			Balanced.performExperiment(LoadLevel.LOAD900, i);
			FourCores.performExperiment(LoadLevel.LOAD700, i);
			FourCores.performExperiment(LoadLevel.LOAD800, i);
			FourCores.performExperiment(LoadLevel.LOAD900, i);
			Autoscaled.performExperiment(LoadLevel.LOAD700, i);
			Autoscaled.performExperiment(LoadLevel.LOAD800, i);
			Autoscaled.performExperiment(LoadLevel.LOAD900, i);
		}
	}

}
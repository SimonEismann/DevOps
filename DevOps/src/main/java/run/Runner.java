package run;

import java.io.IOException;

import experiment.Autoscaled;
import experiment.Balanced;
import experiment.FourCores;
import experiment.OneCore;
import experiment.Regression;
import setup.LoadLevel;

public class Runner {

	public static void main(String[] args) throws InterruptedException, IOException {
		for (int i = 1; i < 11; i++) {
			Regression.performExperiment(LoadLevel.LOAD700, i);
			Regression.performExperiment(LoadLevel.LOAD800, i);
			Regression.performExperiment(LoadLevel.LOAD900, i);
		}
		System.exit(0);
	}
	
}
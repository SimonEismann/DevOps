package run;

import java.io.IOException;

import experiment.Autoscaled;
import experiment.Balanced;
import experiment.FourCores;
import experiment.OneCore;
import setup.LoadLevel;

public class Runner {

	public static void main(String[] args) throws InterruptedException, IOException {

		FourCores.performExperiment(LoadLevel.LOAD900, 3);
		
		Balanced.performExperiment(LoadLevel.LOAD900, 7);
		Balanced.performExperiment(LoadLevel.LOAD800, 8);
		System.exit(0);
	}
	
}
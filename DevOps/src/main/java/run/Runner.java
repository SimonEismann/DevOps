package run;

import java.io.IOException;

import experiment.Autoscaled;
import experiment.Balanced;
import experiment.FourCores;
import experiment.OneCore;
import setup.LoadLevel;

public class Runner {

	public static void main(String[] args) throws InterruptedException, IOException {

		OneCore.performExperiment(LoadLevel.LOAD800, 9);
		
		OneCore.performExperiment(LoadLevel.LOAD900, 1);
		
		FourCores.performExperiment(LoadLevel.LOAD800, 1);
		FourCores.performExperiment(LoadLevel.LOAD900, 2);
		
		Balanced.performExperiment(LoadLevel.LOAD900, 7);
		System.exit(0);
	}
	
}
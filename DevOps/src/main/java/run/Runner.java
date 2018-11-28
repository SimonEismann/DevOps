package run;

import java.io.IOException;

import experiment.Autoscaled;
import experiment.Balanced;
import experiment.FourCores;
import experiment.OneCore;
import setup.LoadLevel;

public class Runner {

	public static void main(String[] args) throws InterruptedException, IOException {

		//OneCore.performExperiment(LoadLevel.LOAD700, 1);
		//OneCore.performExperiment(LoadLevel.LOAD700, 9);
		//OneCore.performExperiment(LoadLevel.LOAD800, 1);
		//OneCore.performExperiment(LoadLevel.LOAD800, 2);
//		OneCore.performExperiment(LoadLevel.LOAD800, 6);
//		OneCore.performExperiment(LoadLevel.LOAD900, 1);
		OneCore.performExperiment(LoadLevel.LOAD900, 2);
		OneCore.performExperiment(LoadLevel.LOAD900, 3);
		OneCore.performExperiment(LoadLevel.LOAD900, 8);
		OneCore.performExperiment(LoadLevel.LOAD900, 9);
		OneCore.performExperiment(LoadLevel.LOAD900, 10);
		
		FourCores.performExperiment(LoadLevel.LOAD700, 1);
		FourCores.performExperiment(LoadLevel.LOAD700, 6);
		FourCores.performExperiment(LoadLevel.LOAD800, 1);
		FourCores.performExperiment(LoadLevel.LOAD800, 2);
		FourCores.performExperiment(LoadLevel.LOAD800, 6);
		FourCores.performExperiment(LoadLevel.LOAD800, 8);
		FourCores.performExperiment(LoadLevel.LOAD900, 2);
		FourCores.performExperiment(LoadLevel.LOAD900, 3);
		FourCores.performExperiment(LoadLevel.LOAD900, 5);
		
		Autoscaled.performExperiment(LoadLevel.LOAD700, 9);
		Autoscaled.performExperiment(LoadLevel.LOAD800, 1);
		Autoscaled.performExperiment(LoadLevel.LOAD800, 6);
		Autoscaled.performExperiment(LoadLevel.LOAD800, 9);
		Autoscaled.performExperiment(LoadLevel.LOAD900, 3);
		
		Balanced.performExperiment(LoadLevel.LOAD700, 6);
		Balanced.performExperiment(LoadLevel.LOAD700, 9);
		Balanced.performExperiment(LoadLevel.LOAD800, 1);
		Balanced.performExperiment(LoadLevel.LOAD700, 8);
		System.exit(0);
	}
	
}
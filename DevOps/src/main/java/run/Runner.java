package run;

import java.io.IOException;

import experiment.Autoscaled;
import experiment.Balanced;
import experiment.FourCores;
import experiment.OneCore;
import setup.LoadLevel;
import setup.Logs;

public class Runner {

	public static void main(String[] args) throws InterruptedException, IOException {
//		Balanced.performExperiment(LoadLevel.LOAD700, "Balanced-700Load");
//		Autoscaled.performExperiment(LoadLevel.LOAD700, "Autoscaled-700Load");
//		OneCore.performExperiment(LoadLevel.LOAD700, "1Core-700Load");
//		FourCores.performExperiment(LoadLevel.LOAD700, "4Cores-700Load");
//
//		Balanced.performExperiment(LoadLevel.LOAD800, "Balanced-800Load");
//		Autoscaled.performExperiment(LoadLevel.LOAD800, "Autoscaled-800Load");
//		OneCore.performExperiment(LoadLevel.LOAD800, "1Core-800Load");
//		FourCores.performExperiment(LoadLevel.LOAD800, "4Cores-800Load");
//
//		Balanced.performExperiment(LoadLevel.LOAD800, "Balanced-800Load");
//		Autoscaled.performExperiment(LoadLevel.LOAD900, "Autoscaled-900Load");
//		OneCore.performExperiment(LoadLevel.LOAD900, "1Core-900Load");
//		FourCores.performExperiment(LoadLevel.LOAD900, "4Cores-900Load");
		
		Logs.collectLogs(32, "asd");
		
		System.exit(0);
	}
	
}
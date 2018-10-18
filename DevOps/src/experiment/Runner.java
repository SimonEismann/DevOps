package experiment;

import java.io.IOException;

import setup.LoadLevel;

public class Runner {

	public static void main(String[] args) throws InterruptedException, IOException {
		FourCores.performExperiment(LoadLevel.LOAD700);
		FourCores.performExperiment(LoadLevel.LOAD800);
		FourCores.performExperiment(LoadLevel.LOAD900);

		OneCore.performExperiment(LoadLevel.LOAD700);
		OneCore.performExperiment(LoadLevel.LOAD800);
		OneCore.performExperiment(LoadLevel.LOAD900);
	}
	
}

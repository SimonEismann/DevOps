package main;

import java.io.IOException;

import experiment.Balanced;
import setup.LoadLevel;

public class Runner {

	public static void main(String[] args) throws InterruptedException, IOException {
		Balanced.performExperiment(LoadLevel.LOAD700);
		Balanced.performExperiment(LoadLevel.LOAD800);
		Balanced.performExperiment(LoadLevel.LOAD900);
		
		System.exit(0);
	}
	
}

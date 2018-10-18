package setup;

public enum LoadLevel {

	LOAD100("100.csv", 100), 
	LOAD150("150.csv", 150), 
	LOAD200("200.csv", 200), 
	LOAD450("450.csv", 450), 
	LOAD500("500.csv", 500), 
	LOAD550("550.csv", 550), 
	LOAD700("700.csv", 700), 
	LOAD800("800.csv", 800), 
	LOAD900("900.csv", 900), 
	LOAD750("750.csv", 750),
	LOAD1000("1000.csv", 1000);
	
	public String fileName;
	public int loadLevel;
	
	private LoadLevel(String fileName, int loadlevel) {
		this.fileName = fileName;
		this.loadLevel = loadlevel;
	}
	
}
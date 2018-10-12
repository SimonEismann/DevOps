package setup;

public enum LoadLevel {

	LOAD100("100.csv", 100), LOAD150("150.csv", 150), LOAD200("200.csv", 200), LOAD450("450.csv", 450), LOAD500("500.csv", 500), LOAD550("550.csv", 550);
	
	public String fileName;
	public int loadLevel;
	
	private LoadLevel(String fileName, int loadlevel) {
		this.fileName = fileName;
		this.loadLevel = loadlevel;
	}
	
}

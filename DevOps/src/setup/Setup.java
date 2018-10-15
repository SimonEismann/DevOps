package setup;

public class Setup {

	public static String webuiIp = "35.242.242.97";
	
	public static void setup4Cores() throws InterruptedException {
		Util.sendCommand("10.1.3.48", "rm -rf Setup/");
		Util.sendCommand("10.1.3.48", "svn co --username sie78ub --password nxhX387F https://se1.informatik.uni-wuerzburg.de/usvn/svn/members/SimonEismann/Experimente/DevOps/Round2/4Cores/Setup");
		Util.sendCommand("10.1.3.48", "cd Setup/ && terraform init");
		Util.sendCommand("10.1.3.48", "cd Setup/ && terraform apply -auto-approve");
		Util.sendCommand("10.1.3.48", "gcloud container clusters get-credentials mycluster --region 'europe-west3-a'");
		Util.sendCommand("10.1.3.48", "cd Setup/ && kubectl apply -f teastore.yaml");
		Thread.sleep(60000);
		webuiIp = Util.sendCommandWithReturn("10.1.3.48", "kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2").trim();
	}
	
	public static void setup5Pools() throws InterruptedException {
		Util.sendCommand("10.1.3.48", "rm -rf Setup/");
		Util.sendCommand("10.1.3.48", "svn co --username sie78ub --password nxhX387F https://se1.informatik.uni-wuerzburg.de/usvn/svn/members/SimonEismann/Experimente/DevOps/Round2/5Pools/Setup");
		Util.sendCommand("10.1.3.48", "cd Setup/ && terraform init");
		Util.sendCommand("10.1.3.48", "cd Setup/ && terraform apply -auto-approve");
		Util.sendCommand("10.1.3.48", "gcloud container clusters get-credentials mycluster --region 'europe-west3-a'");
		Util.sendCommand("10.1.3.48", "cd Setup/ && kubectl apply -f teastore.yaml");
		Thread.sleep(60000);
		Util.sendCommand("10.1.3.48", "cd Setup/ && kubectl apply -f recommender.yaml");
		Thread.sleep(30000);
		webuiIp = Util.sendCommandWithReturn("10.1.3.48", "kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2").trim();
	}
	
	public static void teardown() {
		Util.sendCommand("10.1.3.48", "cd Setup/ && terraform destroy -auto-approve");
	}
}

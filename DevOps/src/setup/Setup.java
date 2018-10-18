package setup;

public class Setup {

	public static String webuiIp = "35.242.242.97";

	public static void setup1Core() throws InterruptedException {
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "rm -rf Setup/"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "svn co --username sie78ub --password nxhX387F https://se1.informatik.uni-wuerzburg.de/usvn/svn/members/SimonEismann/Experimente/DevOps/Round2/1Core/Setup"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform init"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform apply -auto-approve -target=google_container_cluster.primary"));
		Thread.sleep(30000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform apply -auto-approve"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && kubectl apply -f teastore.yaml"));
		Thread.sleep(60000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && kubectl apply -f recommender.yaml"));
		Thread.sleep(30000);
		webuiIp = Util.sendCommandWithReturn("10.1.3.48", "kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2").trim();
	}
	
	public static void setup4Cores() throws InterruptedException {
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "rm -rf Setup/"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "svn co --username sie78ub --password nxhX387F https://se1.informatik.uni-wuerzburg.de/usvn/svn/members/SimonEismann/Experimente/DevOps/Round2/4Cores/Setup"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform init"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform apply -auto-approve -target=google_container_cluster.primary"));
		Thread.sleep(30000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform apply -auto-approve"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && kubectl apply -f teastore.yaml"));
		Thread.sleep(60000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && kubectl apply -f recommender.yaml"));
		Thread.sleep(30000);
		webuiIp = Util.sendCommandWithReturn("10.1.3.48", "kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2").trim();
	}
	
	public static void setup5Pools() throws InterruptedException {
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "rm -rf Setup/"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "svn co --username sie78ub --password nxhX387F https://se1.informatik.uni-wuerzburg.de/usvn/svn/members/SimonEismann/Experimente/DevOps/Round2/5Pools/Setup"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform init"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform apply -auto-approve"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && kubectl apply -f teastore.yaml"));
		Thread.sleep(60000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && kubectl apply -f recommender.yaml"));
		Thread.sleep(30000);
		webuiIp = Util.sendCommandWithReturn("10.1.3.48", "kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2").trim();
	}
	
	public static void teardown() {
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform destroy -auto-approve"));
	}
}

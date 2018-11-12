package setup;

public class Setup {

	public static String webuiIp = "35.242.242.97";

	public static void setup1Core() throws InterruptedException {
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "rm -rf Setup/"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"svn co --username sie78ub --password nxhX387F https://se1.informatik.uni-wuerzburg.de/usvn/svn/members/SimonEismann/Experimente/DevOps/Round2/1Core/Setup"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform init"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"cd Setup/ && terraform apply -auto-approve -target=google_container_cluster.primary"));
		Thread.sleep(120000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform apply -auto-approve"));
		Thread.sleep(300000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"));
		Util.kubectlApply("10.1.3.48", "cd Setup/ && kubectl apply -f teastore.yaml");
		Thread.sleep(120000);
		Util.kubectlApply("10.1.3.48", "cd Setup/ && kubectl apply -f recommender.yaml");
		Thread.sleep(150000);
		webuiIp = Util.sendCommandWithReturn("10.1.3.48",
				"kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2").trim();
	}

	public static void setup4Cores() throws InterruptedException {
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "rm -rf Setup/"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"svn co --username sie78ub --password nxhX387F https://se1.informatik.uni-wuerzburg.de/usvn/svn/members/SimonEismann/Experimente/DevOps/Round2/4Cores/Setup"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform init"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"cd Setup/ && terraform apply -auto-approve -target=google_container_cluster.primary"));
		Thread.sleep(120000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform apply -auto-approve"));
		Thread.sleep(300000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"));
		Util.kubectlApply("10.1.3.48", "cd Setup/ && kubectl apply -f teastore.yaml");
		Thread.sleep(120000);
		Util.kubectlApply("10.1.3.48", "cd Setup/ && kubectl apply -f recommender.yaml");
		Thread.sleep(150000);
		webuiIp = Util.sendCommandWithReturn("10.1.3.48",
				"kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2").trim();
		System.out.println(webuiIp);
	}

	public static void setupAutoscaled() throws InterruptedException {
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "rm -rf Setup/"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"svn co --username sie78ub --password nxhX387F https://se1.informatik.uni-wuerzburg.de/usvn/svn/members/SimonEismann/Experimente/DevOps/Round2/Autoscaled/Setup"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform init"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"cd Setup/ && terraform apply -auto-approve -target=google_container_cluster.primary"));
		Thread.sleep(120000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform apply -auto-approve"));
		Thread.sleep(300000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"));
		Util.kubectlApply("10.1.3.48", "cd Setup/ && kubectl apply -f teastore.yaml");
		Thread.sleep(120000);
		Util.kubectlApply("10.1.3.48", "cd Setup/ && kubectl apply -f recommender.yaml");
		Thread.sleep(150000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"cd Setup/ && kubectl autoscale deployment teastore-persistence --min=1 --max=8 --cpu-percent=80"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"cd Setup/ && kubectl autoscale deployment teastore-auth --min=1 --max=8 --cpu-percent=80"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"cd Setup/ && kubectl autoscale deployment teastore-webui --min=1 --max=8 --cpu-percent=80"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"cd Setup/ && kubectl autoscale deployment teastore-recommender --min=1 --max=8 --cpu-percent=80"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"cd Setup/ && kubectl autoscale deployment teastore-image --min=1 --max=8 --cpu-percent=80"));
		webuiIp = Util.sendCommandWithReturn("10.1.3.48",
				"kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2").trim();
		System.out.println(webuiIp);
	}

	public static void setupBalanced() throws InterruptedException {
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "rm -rf Setup/"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"svn co --username sie78ub --password nxhX387F https://se1.informatik.uni-wuerzburg.de/usvn/svn/members/SimonEismann/Experimente/DevOps/Round2/Balanced/Setup"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform init"));
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"cd Setup/ && terraform apply -auto-approve -target=google_container_cluster.primary"));
		Thread.sleep(120000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform apply -auto-approve"));
		Thread.sleep(300000);
		System.out.println(Util.sendCommandWithReturn("10.1.3.48",
				"gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"));
		Util.kubectlApply("10.1.3.48", "cd Setup/ && kubectl apply -f webui.yaml");
		Thread.sleep(120000);
		Util.kubectlApply("10.1.3.48", "cd Setup/ && kubectl apply -f teastore.yaml");
		Thread.sleep(120000);
		Util.kubectlApply("10.1.3.48", "cd Setup/ && kubectl apply -f recommender.yaml");
		Thread.sleep(30000);
		webuiIp = Util.sendCommandWithReturn("10.1.3.48",
				"kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2").trim();
		System.out.println(webuiIp);
	}

	public static void teardown() {
		System.out.println(Util.sendCommandWithReturn("10.1.3.48", "cd Setup/ && terraform destroy -auto-approve"));
	}

}

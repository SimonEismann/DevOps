package setup;

public class Setup {

	public static String webuiIp = "35.242.242.97";

	public static void setup1Core() throws InterruptedException {
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/1Core/credentials.json", "cd /Setup/1Core", "terraform init", "terraform apply -auto-approve -target=google_container_cluster.primary"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/1Core/credentials.json", "cd /Setup/1Core", "terraform init", "terraform apply -auto-approve"}, false);
		Thread.sleep(300000);
		Util.executeCommands(new String[] {"gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"}, false);
		Thread.sleep(100000);
		Util.executeCommands(new String[] {"cd /Setup/1Core", "kubectl apply -f teastore.yaml"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"cd /Setup/1Core", "kubectl apply -f recommender.yaml"}, false);
		Thread.sleep(150000);
		webuiIp = Util.executeCommands(new String[] {"kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2"}, true).trim();
	}

	public static void setupRegression10() throws InterruptedException {
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/Regression10/credentials.json", "cd /Setup/Regression10", "terraform init", "terraform apply -auto-approve -target=google_container_cluster.primary"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/Regression10/credentials.json", "cd /Setup/Regression10", "terraform init", "terraform apply -auto-approve"}, false);
		Thread.sleep(300000);
		Util.executeCommands(new String[] {"gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"}, false);
		Thread.sleep(100000);
		Util.executeCommands(new String[] {"cd /Setup/Regression10", "kubectl apply -f teastore.yaml"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"cd /Setup/Regression10", "kubectl apply -f recommender.yaml"}, false);
		Thread.sleep(150000);
		webuiIp = Util.executeCommands(new String[] {"kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2"}, true).trim();
	}

	public static void setupRegression30() throws InterruptedException {
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/Regression30/credentials.json", "cd /Setup/Regression30", "terraform init", "terraform apply -auto-approve -target=google_container_cluster.primary"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/Regression30/credentials.json", "cd /Setup/Regression30", "terraform init", "terraform apply -auto-approve"}, false);
		Thread.sleep(300000);
		Util.executeCommands(new String[] {"gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"}, false);
		Thread.sleep(100000);
		Util.executeCommands(new String[] {"cd /Setup/Regression30", "kubectl apply -f teastore.yaml"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"cd /Setup/Regression30", "kubectl apply -f recommender.yaml"}, false);
		Thread.sleep(150000);
		webuiIp = Util.executeCommands(new String[] {"kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2"}, true).trim();
	}

	public static void setup4Cores() throws InterruptedException {
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/4Cores/credentials.json", "cd /Setup/4Cores", "terraform init", "terraform apply -auto-approve -target=google_container_cluster.primary"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/4Cores/credentials.json", "cd /Setup/4Cores", "terraform init", "terraform apply -auto-approve"}, false);
		Thread.sleep(300000);
		Util.executeCommands(new String[] {"gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"}, false);
		Thread.sleep(100000);
		Util.executeCommands(new String[] {"cd /Setup/4Cores", "kubectl apply -f teastore.yaml"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"cd /Setup/4Cores", "kubectl apply -f recommender.yaml"}, false);
		Thread.sleep(150000);
		webuiIp = Util.executeCommands(new String[] {"kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2"}, true).trim();
	}

	public static void setupAutoscaled() throws InterruptedException {
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/Autoscaled/credentials.json", "cd /Setup/Autoscaled", "terraform init", "terraform apply -auto-approve -target=google_container_cluster.primary"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/Autoscaled/credentials.json", "cd /Setup/Autoscaled", "terraform init", "terraform apply -auto-approve"}, false);
		Thread.sleep(300000);
		Util.executeCommands(new String[] {"gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"}, false);
		Thread.sleep(100000);
		Util.executeCommands(new String[] {"cd /Setup/Autoscaled", "kubectl apply -f teastore.yaml"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"cd /Setup/Autoscaled", "kubectl apply -f recommender.yaml"}, false);
		Thread.sleep(150000);
		webuiIp = Util.executeCommands(new String[] {"kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2"}, true).trim();
		
		Util.executeCommands(new String[] {"cd Setup/Autoscaled", "kubectl autoscale deployment teastore-persistence --min=1 --max=8 --cpu-percent=80"}, false);
		Util.executeCommands(new String[] {"cd Setup/Autoscaled", "kubectl autoscale deployment teastore-auth --min=1 --max=8 --cpu-percent=80"}, false);
		Util.executeCommands(new String[] {"cd Setup/Autoscaled", "kubectl autoscale deployment teastore-webui --min=1 --max=8 --cpu-percent=80"}, false);
		Util.executeCommands(new String[] {"cd Setup/Autoscaled", "kubectl autoscale deployment teastore-recommender --min=1 --max=8 --cpu-percent=80"}, false);
		Util.executeCommands(new String[] {"cd Setup/Autoscaled", "kubectl autoscale deployment teastore-image --min=1 --max=8 --cpu-percent=80"}, false);
	}

	public static void setupBalanced() throws InterruptedException {
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/Balanced/credentials.json", "cd /Setup/Balanced", "terraform init", "terraform apply -auto-approve -target=google_container_cluster.primary"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"mv /credentials.json /Setup/Balanced/credentials.json", "cd /Setup/Balanced", "terraform init", "terraform apply -auto-approve"}, false);
		Thread.sleep(300000);
		Util.executeCommands(new String[] {"gcloud container clusters get-credentials mycluster --region 'europe-west3-a'"}, false);
		Thread.sleep(100000);
		Util.executeCommands(new String[] {"cd /Setup/Balanced", "kubectl apply -f teastore.yaml"}, false);
		Thread.sleep(120000);
		Util.executeCommands(new String[] {"cd /Setup/Balanced", "kubectl apply -f recommender.yaml"}, false);
		Thread.sleep(150000);
		webuiIp = Util.executeCommands(new String[] {"kubectl get service teastore-webui | awk '{ print $4}' | tail -n+2"}, true).trim();
	}

	public static void teardown() {
		Util.executeCommands(new String[] {"cd /Setup/1Core", "terraform destroy -auto-approve"}, false);
		Util.executeCommands(new String[] {"cd /Setup/Regression10", "terraform destroy -auto-approve"}, false);
		Util.executeCommands(new String[] {"cd /Setup/Regression30", "terraform destroy -auto-approve"}, false);
		Util.executeCommands(new String[] {"cd /Setup/4Cores", "terraform destroy -auto-approve"}, false);
		Util.executeCommands(new String[] {"cd /Setup/Autoscaled", "terraform destroy -auto-approve"}, false);
		Util.executeCommands(new String[] {"cd /Setup/Balanced", "terraform destroy -auto-approve"}, false);
	}

}

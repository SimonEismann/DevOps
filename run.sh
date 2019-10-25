# Setup gcloud
gcloud projects list
gcloud config set project ${projectname}

# Start loaddriver instances
gcloud compute instances create loaddriver1 --image-family ubuntu-1804-lts --image-project ${projectname} --zone europe-west3-a --image-project ubuntu-os-cloud
gcloud compute instances create loaddriver2 --image-family ubuntu-1804-lts --image-project ${projectname} --zone europe-west3-a --image-project ubuntu-os-cloud
gcloud compute instances create loaddriver3 --image-family ubuntu-1804-lts --image-project ${projectname} --zone europe-west3-a --image-project ubuntu-os-cloud

# Configure loaddriver instances
gcloud compute firewall-rules create loaddriver --allow tcp --description="Expose Loaddriver port"
gcloud compute scp --quiet --zone europe-west3-a --recurse /Load loaddriver1:/Load
gcloud compute ssh --quiet --zone europe-west3-a loaddriver1  << EOF
	ls
	apt-get update
	apt-get install --yes openjdk-8-jdk
	cd /Load
	nohup java -jar httploadgenerator.jar loadgenerator > /Load/loadGeneratorSlaveLogs.txt 2>&1 & 
	exit
EOF
gcloud compute scp --quiet --zone europe-west3-a --recurse /Load loaddriver2:/Load
gcloud compute ssh --quiet --zone europe-west3-a loaddriver2  << EOF
	ls
	apt-get update
	apt-get install --yes openjdk-8-jdk
	cd /Load
	nohup java -jar httploadgenerator.jar loadgenerator > /Load/loadGeneratorSlaveLogs.txt 2>&1 & 
	exit
EOF
gcloud compute scp --quiet --zone europe-west3-a --recurse /Load loaddriver3:/Load
gcloud compute ssh --quiet --zone europe-west3-a loaddriver3  << EOF
	ls
	apt-get update
	apt-get install --yes openjdk-8-jdk
	cd /Load
	nohup java -jar httploadgenerator.jar loadgenerator > /Load/loadGeneratorSlaveLogs.txt 2>&1 & 
	exit
EOF

# Build Project
gradle -b Java/build.gradle clean build 

# Run measurement
java -jar Java/build/libs/Java.jar

# Shutdown loaddriver instances
gcloud compute instances delete loaddriver1 --zone europe-west3-a --quiet
gcloud compute instances delete loaddriver2 --zone europe-west3-a --quiet
gcloud compute instances delete loaddriver3 --zone europe-west3-a --quiet

# MicroservicePerformanceMeasurements
**DISCLAIMER: The measurements will take serveral days and incurr serveal thousands of dollars in hosting costs**

This repository contains the measurement scripts to reproduce the performance measurements included in our manuscript "Microservices: A Performance Tester’s Dream or Nightmare?"

## Prerequisites ##
The full measurement is wrapped in a docker container that install all required software, so all executing the measurements requires only:
* A Google Cloud Account
* Docker 

## Running the measurements ##
In order to run the measurements, follow the following steps:
1. Checkout this repository
2. Create a service account with sufficient privileges for your Google Cloud project
3. Create and download a JSON keyfile for the service account, rename the file to credentials.json and move it to the base folder of the git project
4. Run the following command in a docker-capable commandline (replace NAME_OF_YOUR_PROJECT with the name of your Google Cloud project):

 `docker build -t dev . ; docker run -e projectname="NAME_OF_YOUR_PROJECT" dev`
5. Wait for the script to finish the measurement
6. Run the following command in order to move the results files from the container to your system. Make sure to replace CONTAINER_ID with the id of the measurement container and TARGET_FOLDER with the path to a local folder:

 `docker cp CONTAINER_ID:/ TARGETFOLDER`

## Result interpretation ##
The scripts to recreate the analysis and evaluation of the measurements from the manuscript are available as a CodeOcean capsule (https://doi.org/10.24433/CO.4876239.v1). In order to rerun the analysis using new measurements, simply upload your data to the `measurements` folder in the CodeOcean capsule and press the button `Reproducible Run`. 

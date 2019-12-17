FROM openjdk:8-jdk

ENV projectname = default

#Install python
RUN apt-get --yes update
RUN apt-get --yes install python
RUN apt-get --yes install dos2unix 
RUN apt-get --yes install gradle 

#Install the google SDK
# Downloading gcloud package
RUN curl https://dl.google.com/dl/cloudsdk/release/google-cloud-sdk.tar.gz > /tmp/google-cloud-sdk.tar.gz
RUN mkdir -p /usr/local/gcloud \
  && tar -C /usr/local/gcloud -xvf /tmp/google-cloud-sdk.tar.gz \
  && /usr/local/gcloud/google-cloud-sdk/install.sh
ENV PATH $PATH:/usr/local/gcloud/google-cloud-sdk/bin

# Authentication
COPY credentials.json /credentials.json
RUN gcloud auth activate-service-account --key-file=credentials.json
RUN export GOOGLE_APPLICATION_CREDENTIALS=/credentials.json

# Install Terraform
RUN apt-get update && apt-get install -y \
    wget \
    unzip \
  && rm -rf /var/lib/apt/lists/*
RUN wget --quiet https://releases.hashicorp.com/terraform/0.11.3/terraform_0.11.3_linux_amd64.zip \
  && unzip terraform_0.11.3_linux_amd64.zip \
  && mv terraform /usr/bin \
  && rm terraform_0.11.3_linux_amd64.zip

# Install kubectl
RUN gcloud components install kubectl

# Add setup data
ADD Setup /Setup
COPY credentials.json /Setup/1Core/credentials.json
COPY credentials.json /Setup/4Cores/credentials.json
COPY credentials.json /Setup/Autoscaled/credentials.json
COPY credentials.json /Setup/Balanced/credentials.json
COPY credentials.json /Setup/Regression10/credentials.json
COPY credentials.json /Setup/Regression30/credentials.json

# Add java code
ADD Java /Java

# Add load director
ADD Load /Load

# Add loaddriver
ADD 700.csv 700.csv
ADD 800.csv 800.csv
ADD 900.csv 900.csv
ADD browse.lua browse.lua
ADD httploadgenerator.jar httploadgenerator.jar

# Copy run file
COPY run.sh /run.sh
RUN dos2unix /run.sh

CMD /run.sh

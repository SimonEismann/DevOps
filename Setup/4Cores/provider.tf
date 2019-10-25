provider "google" {
credentials = "${file("credentials.json")}"
project = "devops-218113"
region = "europe-west3"
}
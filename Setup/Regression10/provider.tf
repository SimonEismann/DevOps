provider "google" {
credentials = "${file("credentials.json")}"
project = "PROJECTNAME"
region = "europe-west3"
}
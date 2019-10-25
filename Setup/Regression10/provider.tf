provider "google" {
credentials = "${file("credentials.json")}"
project = "microservice-perf-regr"
region = "europe-west3"
}
resource "google_container_cluster" "primary" {
  name = "mycluster"
  zone = "europe-west3-a"
  initial_node_count = 2
  logging_service = "none"


  node_config {
    labels {
      type = "util"
    }
    machine_type="n1-standard-2"
    oauth_scopes = [
      "https://www.googleapis.com/auth/compute",
      "https://www.googleapis.com/auth/devstorage.read_only",
      "https://www.googleapis.com/auth/logging.write",
      "https://www.googleapis.com/auth/monitoring"
    ]
  }
}
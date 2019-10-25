resource "google_container_node_pool" "worker_pool" {
  name       = "worker"
  cluster    = "${google_container_cluster.primary.name}"
  zone       = "europe-west3-a"
  node_count = "5"

  node_config {
    labels {
      type = "worker"
    }
    machine_type = "custom-4-26624"
  }
}
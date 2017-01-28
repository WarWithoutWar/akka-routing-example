# akka-routing-example

Application demonstrate routing in Akka. Producer publishes a set of data and the routes to a consumer which process the data then returns the data to the producer



# Creates a round robin type routing, which dynamically resizes
- val resizer = DefaultResizer(lowerBound = 2, upperBound = 15)
- val consumer = system.actorOf(RoundRobinPool(1, Some(resizer)).props(Props[ConsumerActor]), "route1") 




# Routing config from config file 
val consumer = system.actorOf(FromConfig.props(Props[ConsumerActor]), "route1")

- The config file
- akka {
  actor{
    deployment {
      /route1 {
      router = "round-robin-pool"
      nr-of-instances = 8
      }
    }
  }
}

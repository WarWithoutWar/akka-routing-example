import akka.actor.{Props, ActorSystem}
import akka.routing.{FromConfig, DefaultResizer, RoundRobinPool}
import com.typesafe.config.ConfigFactory

object AkkaRouting extends App{
  val system =  ActorSystem("System", ConfigFactory.load("akka"))

  val producer = system.actorOf(Props[ProducerActor], "Producer")


  // Create routing by code (resizer added)
//  val resizer = DefaultResizer(lowerBound = 2, upperBound = 15)
//  val consumer = system.actorOf(RoundRobinPool(1, Some(resizer)).props(Props[ConsumerActor]), "route1")

  // using config
  val consumer = system.actorOf(FromConfig.props(Props[ConsumerActor]), "route1")


  consumer.tell(Data(List(1, 5, 6, 9, 3, 1, 10, 11, 100, 1000)), producer)
  consumer.tell(Data(List(11, 100, 23, 5, 6, 9, 3, 1, 2000)), producer)
  consumer.tell(Data(List(11, 9, 3,100, 23, 5, 6, 1, 3000)), producer)
  consumer.tell(Data(List(11, 9,  9, 3,100, 23, 5, 6, 4000)), producer)
  consumer.tell(Data(List(1, 9, 3,100, 23, 5, 6, 1, 1, 5000)), producer)



}

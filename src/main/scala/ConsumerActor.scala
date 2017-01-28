import akka.actor.Actor
import akka.actor.Actor.Receive

case class Data(data : List[Int])
case class ProcessedData(data : Int)

class ConsumerActor extends Actor{

  override def receive: Receive = {
    case Data(data) =>  {
      println(context.self.path.name + ": Got the data with max number: " + data.max)
      sender ! ProcessedData(data.max)
    }
  }

}

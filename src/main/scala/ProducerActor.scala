import akka.actor.{Props, Actor}
import akka.routing.FromConfig


class ProducerActor extends Actor{

  override def receive: Receive = {
    case processedData: ProcessedData => DisplayProcessedData(processedData)
  }

  def DisplayProcessedData(processedData: ProcessedData): Unit = println(processedData.data +  " By:" + sender.path.name )

}

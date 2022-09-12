package appPackage.view

import appPackage.model.{SensorInput, SensorOutput}

import scala.collection.immutable.List

object Viewer {
  def viewerForInts(string: String, int: Int): Unit = {
    println(string + ": " + int)
  }
  def viewerForSensorInputWithFile(sensorInput:List[(String, List[SensorInput])]): Unit ={
    sensorInput.foreach( x=> (println("\n"+x._1+"\n```"),x._2.foreach(y=>println(y.sensorId+","+y.humidity)),println("```")) )
  }
  def viewerForSensorOutput(sensorOutput:List[SensorOutput]): Unit ={
    println("Sensors with highest avg humidity:\n\nsensor-id,min,avg,max")
    sensorOutput.sortWith(_.avg.toDouble > _.avg.toDouble).foreach((y=>println(y.sensorId+","+y.min+","+y.avg+","+y.max)))
    println("```")
  }


}

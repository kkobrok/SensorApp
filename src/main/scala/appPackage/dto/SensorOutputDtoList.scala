package appPackage.dto

import appPackage.model.{SensorInput, SensorOutput, SensorOutputTemp}

import scala.annotation.tailrec

//TODO
final class SensorOutputDtoList(sensorInputList: List[SensorInput]) {
  def toSensorOutput(): List[SensorOutput] = {
    val test = sensorInputToSensorOutputTemp(sensorInputList, List[SensorOutputTemp]())
    val test1 = test.map(x => x.sensorId).distinct
    val test2 = test1.map(x => try {
      SensorOutputTemp(

        x,
        test.filter(y => y.sensorId == x && y.min != "NaN").map(z => z.min.toInt).min.toString,
        test.filter(y => y.sensorId == x && y.max != "NaN").map(z => z.max.toInt).max.toString,
        test.filter(y => y.sensorId == x && y.listForAvg.head.toString != "NaN").map(z => z.listForAvg.head)
      )
    }
    catch {
      case e: UnsupportedOperationException => new SensorOutputTemp(x, "NaN", "NaN", List())
    }
    )
    //    test2.map()

    sensorInputToSensorOutput(test2)
  }

  def average(s: Seq[Double]): Double = s.foldLeft((0.0, 1))((acc, i) => ((acc._1 + (i - acc._1) / acc._2), acc._2 + 1))._1

//TODO
  def sensorInputToSensorOutput(listSensorOutput: List[SensorOutputTemp]): List[SensorOutput] = {
    if (listSensorOutput.isEmpty) {
      Nil
    }
    else {
      SensorOutput(
        listSensorOutput.head.sensorId,
        listSensorOutput.head.min,
        listSensorOutput.head.max,
        listSensorOutput.head.listForAvg
                match{
                  case Nil => "NaN"
                  case _ => average(listSensorOutput.head.listForAvg).toString
                }
      )::
      sensorInputToSensorOutput(listSensorOutput.tail)
    }
  }

  def listUpdater(sensorInput: SensorInput, listSensorOutput: List[SensorOutputTemp]): List[SensorOutputTemp] = {

    listSensorOutput.appended(
      new SensorOutputTemp(sensorInput.sensorId,
        sensorInput.humidity,
        sensorInput.humidity,
        List(sensorInput.humidity.toDouble)))

  }

  @tailrec
  def sensorInputToSensorOutputTemp(sensorInputList: List[SensorInput], listSensorOutputTemp: List[SensorOutputTemp]): List[SensorOutputTemp] = {
    if (sensorInputList.isEmpty)
      listSensorOutputTemp
    else {


      sensorInputToSensorOutputTemp(sensorInputList.tail, listUpdater(sensorInputList.head, listSensorOutputTemp).sortBy(_.sensorId))

    }


  }
}

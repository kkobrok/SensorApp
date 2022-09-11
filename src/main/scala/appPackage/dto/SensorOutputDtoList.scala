package appPackage.dto

import appPackage.model.{SensorInput, SensorOutput, SensorOutputTemp}

import scala.annotation.tailrec


final class SensorOutputDtoList(sensorInputList: List[SensorInput]) {
  def toSensorOutput(): List[SensorOutput] = {
    sensorInputToSensorOutput(sensorInputToSensorOutputTemp(sensorInputList, List[SensorOutputTemp]()))
  }

  def average(s: Seq[Double]): Double = s.foldLeft((0.0, 1))((acc, i) => ((acc._1 + (i - acc._1) / acc._2), acc._2 + 1))._1

  def min(sensorInput: SensorInput, sensorOutputTemp: SensorOutputTemp): String = {
    if (sensorOutputTemp.min.toDouble < sensorInput.humidity.toDouble)
      sensorOutputTemp.min
    else
      sensorInput.humidity
  }

  def max(sensorInput: SensorInput, sensorOutputTemp: SensorOutputTemp): String = {
    if (sensorOutputTemp.max.toDouble > sensorInput.humidity.toDouble)
      sensorOutputTemp.max
    else
      sensorInput.humidity
  }

  def sensorInputToSensorOutput(listSensorOutput: List[SensorOutputTemp]): List[SensorOutput] = {
    if (listSensorOutput.isEmpty) {
      Nil
    }
    else {
      SensorOutput(
        listSensorOutput.head.sensorId,
        listSensorOutput.head.min,
        listSensorOutput.head.max,
        average(listSensorOutput.head.listForAvg).toString) ::
        sensorInputToSensorOutput(listSensorOutput.tail)


    }
  }
  @tailrec
  def listUpdater(sensorInput: SensorInput, listSensorOutput: List[SensorOutputTemp]): List[SensorOutputTemp] = {

    if (listSensorOutput.nonEmpty && sensorInput.sensorId.equals(listSensorOutput.head.sensorId)) {
      listSensorOutput.tail.appended(new SensorOutputTemp(listSensorOutput.head.sensorId, min(sensorInput, listSensorOutput.head), max(sensorInput, listSensorOutput.head),
        listSensorOutput.head.listForAvg.appended(sensorInput.humidity.toDouble)))
    } else {
      if (listSensorOutput.isEmpty) {
        listSensorOutput.appended(
          new SensorOutputTemp(sensorInput.sensorId,
            sensorInput.humidity,
            sensorInput.humidity,
            List(sensorInput.humidity.toDouble)))
      } else {
        listUpdater(sensorInput, listSensorOutput.tail)
      }

    }
  }

  @tailrec
  def sensorInputToSensorOutputTemp(sensorInputList: List[SensorInput], listSensorOutputTemp: List[SensorOutputTemp]): List[SensorOutputTemp] = {
    if (sensorInputList.isEmpty)
      listSensorOutputTemp
    else if (sensorInputList.head.humidity.equals("NaN")) {
      (sensorInputToSensorOutputTemp(sensorInputList.tail, listSensorOutputTemp))
    } else {
      sensorInputToSensorOutputTemp(sensorInputList.tail, listUpdater(sensorInputList.head, listSensorOutputTemp))

    }


  }
}

package packasd

import com.github.tototoshi.csv.CSVReader
import packasd.dto.{SensorInput, SensorOutput}

import java.io.File
import java.nio.file.Files
import scala.collection.immutable.List

trait SensorReader {
  def run(): Unit = {


  }

  def getListOfFiles(pathToFile: String): List[File] = {
    val d = new File(pathToFile)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  def readCsv(listOfFile: List[File]): List[List[String]] = {
    ???
  }

  def translateToSensorInput(listOfFile: List[File]): List[SensorInput] = {
    ???
  }

  def translateToSensorOutput(listOfFile: List[File]): List[SensorOutput] = {
    ???
  }

  def howManyProcessed(): Int = {
    ???
  }

  def howManyMeasurementsFailed(): Int = {
    ???
  }
  def howManyMeasurementsProcessed(): Int = {
    ???
  }




  //tu ma być logika
}

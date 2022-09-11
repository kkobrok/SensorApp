package appPackage

import com.github.tototoshi.csv.CSVReader
import appPackage.model.{SensorInput, SensorOutput}

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

  def translateToSensorInput(listOfFile: List[File]): List[List[SensorInput]] = {
    ???
  }

  def translateToSensorOutput(listOfListOfSensorInput: List[List[SensorInput]]): List[List[SensorOutput]] = {
    ???
  }

  def howManyProcessed(listOfFile: List[File]): Int = listOfFile.length

  def howManyMeasurementsFailedAndProcessed(listOfListOfSensorInput: List[List[SensorInput]],
                                            listOfListOfSensorOutput: List[List[SensorOutput]]): (Int,Int) = {
    (listOfListOfSensorInput.length - listOfListOfSensorOutput.length, listOfListOfSensorOutput.length)
  }





  //tu ma być logika
}

package appPackage

import appPackage.dto.{SensorInputDto, SensorOutputDtoList}
import com.github.tototoshi.csv.CSVReader
import appPackage.model.{SensorInput, SensorOutput}
import appPackage.view.Viewer

import java.io.File

trait SensorReader {
  def run(filePath: String): Unit = {
    val listOfFile = getListOfFiles(filePath)
    val listOfSensorInputXFile = translateToSensorInput(listOfFile)
    Viewer.viewerForSensorInputWithFile(listOfSensorInputXFile)
    val listOfSensorInput = listOfSensorInputXFileToListOfSensorInput(listOfSensorInputXFile)
    val listOfSensorOutput = translateToSensorOutput(listOfSensorInput)
    Viewer.viewerForInts("Num of processed files",howManyProcessed(listOfFile))
    Viewer.viewerForInts("Num of processed measurements",listOfSensorInput.length)
    Viewer.viewerForInts("Num of failed measurements",listOfSensorInput.count(x=>x.humidity=="NaN"))
    Viewer.viewerForSensorOutput(listOfSensorOutput)

  }

  def getListOfFiles(pathToFile: String): List[File] = {
    val d = new File(pathToFile)
    if (d.exists && d.isDirectory) {
      d.listFiles.filter(_.isFile).toList
    } else {
      List[File]()
    }
  }

  def translateToSensorInput(listOfFile: List[File]): List[(String, List[SensorInput])] = {
    listOfFile.map(x => (x.getName, CSVReader.open(x).all().map(y =>(new SensorInputDto(y)).toSensorInput())))
  }

  def translateToSensorOutput(listOfListOfSensorInput:  List[SensorInput]): List[SensorOutput] = {
    new SensorOutputDtoList( listOfListOfSensorInput).toSensorOutput()
  }

  def listOfSensorInputXFileToListOfSensorInput(listOfListOfSensorInputXFile: List[(String, List[SensorInput])]): List[SensorInput] ={
    listOfListOfSensorInputXFile.flatMap(x => x._2).filter(y=>y.sensorId!="sensor-id")
  }


  def howManyProcessed(listOfFile: List[File]): Int = listOfFile.length


}

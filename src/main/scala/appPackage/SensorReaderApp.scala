package appPackage

import com.github.tototoshi.csv.CSVReader

import java.io.File


object SensorReaderApp {

  def main(args: Array[String]): Unit = {
    val cmdParams = SensorReaderAppParams.parseArgs(args)
    val valueOfPath = cmdParams.filePath
      println(cmdParams.toString)
      println(valueOfPath.toString)
    val reader = CSVReader.open(new File(valueOfPath.toString))
    println(reader.all())
  }
//tu ma byc tylko main params i odpalenie live matintece  czyly sensor reader
}

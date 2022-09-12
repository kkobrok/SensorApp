package appPackage

import com.github.tototoshi.csv.CSVReader

import java.io.File


object SensorReaderApp {

  def main(args: Array[String]): Unit = {
    val cmdParams = SensorReaderAppParams.parseArgs(args)
    LiveSensorReader().run(cmdParams.filePath)
  }
//tu ma byc tylko main params i odpalenie live matintece  czyly sensor reader
}

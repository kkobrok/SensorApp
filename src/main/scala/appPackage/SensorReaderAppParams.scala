package appPackage

import java.io.File
import scala.Console.out
import scopt.OParser


final case class SensorReaderAppParams (filePath:String = "") {

}
object SensorReaderAppParams {


  import scopt.OParser

  val builder = OParser.builder[SensorReaderAppParams]
  val parser = {
    import builder._
    OParser.sequence(
      programName("Sensor"),
      head(""),
      opt[String]('p', "filePath")
        .required()
        .action((x, c) => c.copy(filePath = x))
        .text("foo is an integer property")
    )
  }

  def parseArgs(args: Array[String]): SensorReaderAppParams = OParser.parse(parser, args,
    SensorReaderAppParams()) match {
      case Some(params) => params
      case _ => throw new IllegalArgumentException("asda")
    }
}
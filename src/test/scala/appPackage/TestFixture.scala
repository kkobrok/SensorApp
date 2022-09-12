package appPackage

import appPackage.dto.SensorOutputDtoList
import appPackage.model.{SensorInput, SensorOutput, SensorOutputTemp}

object TestFixture {

  val testSensorOutputTemp = SensorOutputTemp("s1", "10", "100", List(10, 40, 100))
  val testSensorInput = SensorInput("s1", "200")

  val testListOfSensorOutputTemp: List[SensorOutputTemp] = List(
    SensorOutputTemp("s1", "10", "100", List(10, 40, 100)),
    SensorOutputTemp("s2", "100", "100", List(100)),
    SensorOutputTemp("s3", "50", "100", List(50, 100)))

  val testListOfSensorOutput: List[SensorOutput] = List(
    SensorOutput("s1", "10", "100", "50.0"),
    SensorOutput("s2", "100", "100", "100.0"),
    SensorOutput("s3", "50", "100", "75.0"))

  val testListOfSensorInput: List[SensorInput] = List(
    SensorInput("s1", "100"),
    SensorInput("s1", "NaN"),
    SensorInput("s1", "40"),
    SensorInput("s1", "10"),
    SensorInput("s2", "100"),
    SensorInput("s2", "NaN"),
    SensorInput("s3", "50"),
    SensorInput("s3", "100"))

  val testListOfSensorInputNan: List[SensorInput] = List(
    SensorInput("s1", "100"),
    SensorInput("s1", "NaN"),
    SensorInput("s1", "40"),
    SensorInput("s1", "10"),
    SensorInput("s2", "100"),
    SensorInput("s2", "NaN"),
    SensorInput("s3", "50"),
    SensorInput("s3", "100"),
    SensorInput("s4", "NaN"),
    SensorInput("s5", "NaN"))

  val testListOfSensorOutputNaN: List[SensorOutput] = List(
    SensorOutput("s1", "10", "100", "50.0"),
    SensorOutput("s2", "100", "100", "100.0"),
    SensorOutput("s3", "50", "100", "75.0"),
    SensorOutput("s4", "NaN","NaN","NaN"),
    SensorOutput("s5", "NaN","NaN","NaN")
  )

  val testInstanceSensorOutputDtoList: SensorOutputDtoList = new SensorOutputDtoList(testListOfSensorInput)

  val testInstanceSensorOutputDtoListNan: SensorOutputDtoList = new SensorOutputDtoList(testListOfSensorInputNan)


}

package appPackage.dto

import appPackage.model.SensorInput
import org.scalatest.flatspec.AnyFlatSpec

class SensorInputDtoTest extends AnyFlatSpec {
  it should "create SensorInput" in {
    val test = new SensorInputDto(List("s1", "10")).toSensorInput()
    assert(test.isInstanceOf[SensorInput])
  }
  it should "throw IllegalArgumentException" in {
    assertThrows[IllegalArgumentException](new SensorInputDto(List("s1")).toSensorInput())
  }

  it should "have corresponding values " in {
    val test = new SensorInputDto(List("s1", "10")).toSensorInput()
    assert("s1"== test.sensorId && "10"== test.humidity)
  }
}

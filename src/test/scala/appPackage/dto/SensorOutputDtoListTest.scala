package appPackage.dto

import appPackage.model.SensorInput
import org.scalatest.flatspec.AnyFlatSpec

class SensorOutputDtoListTest extends AnyFlatSpec {
  it should "create SensorInput" in {
    val test = new SensorOutputDtoList().toSensorOutput()
    assert(test.isInstanceOf[List[SensorInput])
  }
  it should "throw IllegalArgumentException" in {
    assertThrows[IllegalArgumentException](new SensorOutputDtoList().toSensorOutput())
  }

  it should "have corresponding values " in {
    val test = new SensorOutputDtoList().toSensorOutput()
    assert()
  }
}

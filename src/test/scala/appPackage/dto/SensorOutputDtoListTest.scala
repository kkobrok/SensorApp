package appPackage.dto

import appPackage.TestFixture.{testInstanceSensorOutputDtoList, testInstanceSensorOutputDtoListNan, testListOfSensorInput, testListOfSensorOutput, testListOfSensorOutputNaN, testListOfSensorOutputTemp, testSensorInput, testSensorOutputTemp}
import appPackage.model.{SensorInput, SensorOutputTemp}
import org.scalatest.flatspec.AnyFlatSpec

class SensorOutputDtoListTest extends AnyFlatSpec {



  it should "average" in {//ok
    assert(testInstanceSensorOutputDtoList.average(List(5.0, 10.0, 15.3)) == 10.1)
  }


  it should "sensorInputToSensorOutput" in {
    assert(testInstanceSensorOutputDtoList.sensorInputToSensorOutput(testListOfSensorOutputTemp).equals(testListOfSensorOutput))

  }


  it should "listUpdater with Empty SensorOutputTemp" in {
    val test = testInstanceSensorOutputDtoList.listUpdater(testSensorInput, List())
    assert(test.contains(SensorOutputTemp("s1", "200", "200", List(200)))
    )
  }


  it should "toSensorOutput" in {
    val test = testInstanceSensorOutputDtoList.toSensorOutput()

    assert(test.equals(testListOfSensorOutput))

  }



  it should "toSensorOutput with Nan" in {
    val test = testInstanceSensorOutputDtoListNan.toSensorOutput()

    assert(test.equals(testListOfSensorOutputNaN))

  }


}

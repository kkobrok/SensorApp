package appPackage.dto

import appPackage.TestFixture.{testInstanceSensorOutputDtoList, testListOfSensorInput, testListOfSensorOutput, testListOfSensorOutputTemp, testSensorInput, testSensorOutputTemp}
import appPackage.model.{SensorInput, SensorOutputTemp}
import org.scalatest.flatspec.AnyFlatSpec

class SensorOutputDtoListTest extends AnyFlatSpec {



  it should "sensorInputToSensorOutputTemp" in {
    assert(testInstanceSensorOutputDtoList.sensorInputToSensorOutputTemp(testListOfSensorInput,Nil ).equals(testListOfSensorOutput))
  }


  it should "average" in {//ok
    assert(testInstanceSensorOutputDtoList.average(List(5.0, 10.0, 15.3)) == 10.1)
  }

  it should "max" in {//ok
    assert(testInstanceSensorOutputDtoList.max(testSensorInput,testSensorOutputTemp) == "200")

  }

  it should "min" in {//ok
    assert(testInstanceSensorOutputDtoList.min(testSensorInput,testSensorOutputTemp) == "10")

  }

  it should "sensorInputToSensorOutput" in {
    assert(testInstanceSensorOutputDtoList.sensorInputToSensorOutput(testListOfSensorOutputTemp).equals(testListOfSensorOutput))

  }

  it should "listUpdater" in {
    val test = testInstanceSensorOutputDtoList.listUpdater(testSensorInput,testListOfSensorOutputTemp)
    assert(test.contains(SensorOutputTemp("s1", "10", "200", List(10, 40, 100,200)))
    )
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


}

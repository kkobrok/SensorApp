package appPackage.dto

import appPackage.model.SensorInput

final class SensorInputDto(line: List[String]) {
  def toSensorInput(): SensorInput = {
    if (line.length != 2) {
      throw new IllegalArgumentException("Sensor Data is corrupted")
    }
    new SensorInput(line(0), line(1))
  }
}

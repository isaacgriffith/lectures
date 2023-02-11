public class Driver {

  public static void main(String args[]) {

    WeatherStation station = new WeatherStation();

    Sensor humidity = new HumiditySensor();
    Sensor temp = new TemperatureSensor();
    Sensor alt = new AltitudeSensor();

    humidity.addSensorListener(station);
    temp.addSensorListener(station);
    alt.addSensorListener(station);
  }
}

public class WeatherStation {
  List<Sensor> sensors;
  List<Display> displays;

  public void init() {
    sensors = new ArrayList<>(new HumiditySensor(), new TemperatureSensor(), new AltitudeSensor());

    for (Sensor s : sensors) {
      for (Display d : displays) {
        s.addSensorListener(d);
      }
    }
  }
}

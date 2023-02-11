public abstract class Sensor() {

  private float data;
  private List<SensorListener> listeners;

  public float getData() {
    return data;
  }

  public void addSensorListener(SensorListener l) {
    if (listeners == null)
      listeners = new ArrayList<>();
    if (l != null && !listeners.contains(l))
      listeners.add(l);
  }

  public void removeSensorListener(SensorListener l) {
    if (l != null && listeners != null && listeners.contains(l))
      listeners.remove(l);
  }

  public void notifyAll() {
    for (SensorListener l : listeners) {
      l.notify(this.getData());
    }
  }

  public abstract String getName();

}

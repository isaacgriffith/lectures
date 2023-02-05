package edu.isu.cs.cs2263.examples.fsms;

public class Clock implements Runnable {
  private static Microwave microwave;
  public Clock() {
    microwave = Microwave.instance();
    new Thread(this).start();
  }

  public void run() {
    try {
      while (true) {
        Thread.sleep(1000);
        microwave.clockTicked();
      }
    } catch (InterruptedException ignored) {}
  }
}

package edu.isu.cs2263.lab03.prob04;

// This is a code fragment for a multi-sensor HVAC (heating/air conditioning) system display.
public class HVACController {
    // ...
    void updateDisplay () {
        double tenInsideTemps = 0;
        double tenOutsideTemps = 0.0;
        // implemented in/out temp so far,
        // still have in/out humidity and 2nd floor temps to go
        for(int i=0; i<10; i++){
            tenInsideTemps = tenInsideTemps + insideSensor.getTemp();
            tenOutsideTemps = tenOutsideTemps + outsideSensor.getTemp();
            TimeUnit.SECONDS.sleep(1); // ten readings to average
        }
        double aveInsideTemp = tenInsideTemps / 10;
        double aveOutsideTemp = tenOutsideTemps / 10;
        display.setInsideTemp(aveInsideTemp);
        display.setOutsideTemp(aveOutsideTemp);
    }
}

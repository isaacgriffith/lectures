package edu.isu.cs.cs2263.examples.fsms;

public interface MicrowaveDisplay {
    void setMicrowave(Microwave microwave);
    void turnLightOn();
    void turnLightOff();
    void doorClosed();
    void doorOpened();
    void startCooking();
    void notCooking();
    void timeRemaining(int time);
}

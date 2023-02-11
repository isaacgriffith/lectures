package edu.isu.cs.cs2263.examples.fsms;

public class Microwave {

    public enum States { DOOR_CLOSED_STATE, DOOR_OPENED_STATE, COOKING_STATE };
    private int timeRemaining;
    private States currentState;
    private static Microwave instance;
    private final MicrowaveDisplay display;

    private Microwave() {
        currentState = States.DOOR_CLOSED_STATE;
        timeRemaining = 0;
        display = new GUIDisplay();
        display.setMicrowave(this);
        display.timeRemaining(timeRemaining);
        display.turnLightOff();
        display.doorClosed();
        display.notCooking();
    }

    public static Microwave instance() {
        if (instance == null) {
            return instance = new Microwave();
        }

        return instance;
    }

    public void clockTicked() {
        if (currentState == States.COOKING_STATE) {
            timeRemaining--;
            display.timeRemaining(timeRemaining);
            if (timeRemaining == 0) {
                currentState = States.DOOR_CLOSED_STATE;
                display.notCooking();
                display.turnLightOff();
            }
        }
    }

    public void processCookRequest() {
        if (currentState == States.DOOR_CLOSED_STATE) {
            currentState = States.COOKING_STATE;
            display.startCooking();
            display.turnLightOn();
            timeRemaining = 60;
            display.timeRemaining(timeRemaining);
        } else if (currentState == States.COOKING_STATE) {
            timeRemaining += 60;
            display.timeRemaining(timeRemaining);
        }
    }

    public void processDoorOpen() {
        if (currentState == States.COOKING_STATE) {
            currentState = States.DOOR_OPENED_STATE;
            display.doorOpened();
            display.notCooking();
            display.timeRemaining(timeRemaining);
        } else if (currentState == States.DOOR_CLOSED_STATE) {
            currentState = States.DOOR_OPENED_STATE;
            display.notCooking();
            display.doorOpened();
            display.turnLightOn();
            display.timeRemaining(timeRemaining);
        }
    }

    public void processDoorClosed() {
        if (currentState == States.DOOR_OPENED_STATE) {
            if (timeRemaining != 0) {
                currentState = States.COOKING_STATE;
                display.startCooking();
                display.turnLightOn();
                display.doorClosed();
            } else {
                currentState = States.DOOR_CLOSED_STATE;
                display.notCooking();
                display.turnLightOff();
                display.doorClosed();
            }
            display.timeRemaining(timeRemaining);
        }
    }

    public static void main(String[] args) {
        new Clock();
    }
}

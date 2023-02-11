package edu.isu.cs.cs2263.examples.fsms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIDisplay extends JFrame implements MicrowaveDisplay, ActionListener {

    private Microwave microwave;
    private final JButton doorCloser = new JButton("close door");
    private final JButton doorOpener = new JButton("open door");
    private final JButton cookButton = new JButton("cook");
    private final JLabel doorStatus = new JLabel("Door Closed");
    private final JLabel timerValue = new JLabel("           ");
    private final JLabel lightStatus = new JLabel("Light Off");
    private final JLabel cookingStatus = new JLabel("Not cooking");

    public GUIDisplay() {
        super("Microwave");
        addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent event){
                System.exit(0);
            }
        });
        getContentPane().setLayout(new FlowLayout());
        Container c = getContentPane();
        c.add(doorStatus);
        c.add(lightStatus);
        c.add(timerValue);
        c.add(cookingStatus);
        c.add(doorCloser);
        c.add(doorOpener);
        c.add(cookButton);
        doorCloser.addActionListener(this);
        doorOpener.addActionListener(this);
        cookButton.addActionListener(this);
        pack();
        setVisible(true);
    }

    @Override
    public void setMicrowave(Microwave microwave) {
        this.microwave = microwave;
    }

    @Override
    public void turnLightOn() {
        lightStatus.setText("Light On");
    }

    @Override
    public void turnLightOff() {
        lightStatus.setText("Light Off");
    }

    @Override
    public void doorClosed() {
        doorStatus.setText("Door Closed");
    }

    @Override
    public void doorOpened() {
        doorStatus.setText("Door Open");
    }

    @Override
    public void startCooking() {
        cookingStatus.setText("Cooking");
    }

    @Override
    public void notCooking() {
        cookingStatus.setText("Not Cooking");
    }

    @Override
    public void timeRemaining(int time) {
        timerValue.setText(String.format("%1$11d", time));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource().equals(doorCloser))
            microwave.processDoorClosed();
        else if (event.getSource().equals(doorOpener))
            microwave.processDoorOpen();
        else if (event.getSource().equals(cookButton))
            microwave.processCookRequest();
    }
}

package edu.isu.cs.cs2263.runnable;

public class Clock implements Runnable {

    Thread thread = new Thread(this);
    String sound = "tic";

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(sound);
                sound = "toc";
                Thread.sleep(1000);
                System.out.println(sound);
                sound = "tic";
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {}
    }

    public Clock() {
        thread.start();
    }

    public static void main(String[] args) {
        new Clock();
    }
}

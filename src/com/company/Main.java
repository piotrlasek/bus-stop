package com.company;

/**
 *
 */
public class Main {

    /**
     *
     * @param sec
     */
    public static void sleep(int sec) {
        try {
            Thread.sleep((long) (sec * (1000 * Math.random())));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Stop stop = new Stop();

        Bus b = new Bus(0, stop);
        new Thread(b).start();

        for(int i = 0; i < 3; i++) {
            Passenger p = new Passenger(i, stop);
            Main.sleep(1);
            new Thread(p).start();
        }


    }
}

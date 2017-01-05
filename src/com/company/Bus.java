package com.company;

/**
 * Created by Piotr on 04.01.2017.
 */
public class Bus implements Runnable {

    private final Stop stop;
    int id;

    /**
     *
     * @param id
     * @param stop
     */
    public Bus(int id, Stop stop) {
        this.id = id;
        this.stop = stop;
    }

    @Override
    /**
     *
     */
    public void run() {
        System.out.println(getId() + " Starting the engine...");
        Main.sleep(5);
        System.out.println(getId() + " Driving...");
        Main.sleep(6);
        System.out.println(getId() + " Arrived!");
        Main.sleep(1);

        synchronized (stop) {
            stop.notifyAll();
        }

        Main.sleep(3);
        System.out.println(getId() + " Departing...");
    }

    /**
     *
     * @return
     */
    private String getId() {
        return "[BUS: " + id + "]";
    }
}

package com.company;

/**
 * Created by Piotr on 04.01.2017.
 */
public class Passenger implements Runnable {

    int id;
    Stop stop;

    /**
     *
     * @param id
     * @param stop
     */
    public Passenger(int id, Stop stop) {
        this.id = id;
        this.stop = stop;
    }

    @Override
    /**
     *
     */
    public void run() {
        System.out.println(getId() + " Waking up...");
        Main.sleep(1);
        System.out.println(getId() + " Going to the bus stop...");
        Main.sleep(1);
        System.out.println(getId() + " Waiting for a bus...");

        synchronized (stop) {
            try {
                stop.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(getId() + " Getting on...");
    }

    /**
     *
     * @return
     */
    public String getId() {
        return "[P: " + id + "]";
    }
}

package com.example.restaurantfx;

public class updateOrderViewThread implements Runnable {
    Thread t;
    showRestaurantDetailsFromManagerViewController main;
    public updateOrderViewThread(showRestaurantDetailsFromManagerViewController main) {
        this.main = main;
        t = new Thread(this);
        t.start();

    }

    @Override
    public void run() {
        try{
            while(true) {
            main.initializeColumns3();
            Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

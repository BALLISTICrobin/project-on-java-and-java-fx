package com.example.restaurantfx;

import javafx.application.Platform;


import java.io.IOException;

public class clientRestaurantReadThread implements Runnable {
    private  Thread thr;
    private  mainRestaurantManager main;

    public clientRestaurantReadThread(mainRestaurantManager main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getNetworkUtil().read();
                if (o != null) {
                    if (o instanceof LoginDTR) {
                        LoginDTR loginDTR = (LoginDTR) o;
                        System.out.println(loginDTR.getUserName());
                        System.out.println(loginDTR.isStatus());
                        if (loginDTR.isStatus()) {
                            try {
                                main.setId(loginDTR.getId());
//                                System.out.println(main.getId());
                                main.showRestaurants();
                            } catch (Exception e) {
                                System.out.println("HELLO");
                                e.printStackTrace();
                            }
                        } else {
                            main.showAlert();
                        }
                    }
                    else if(o instanceof Order){
                        Order order = (Order) o;
                        main.orderList.add(order);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
//        finally {
//            try {
//                main.getNetworkUtil().closeConnection();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}


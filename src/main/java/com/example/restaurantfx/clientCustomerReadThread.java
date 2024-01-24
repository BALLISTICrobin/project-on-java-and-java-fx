package com.example.restaurantfx;

import javafx.application.Platform;


import java.io.IOException;

public class clientCustomerReadThread implements Runnable {
    private  Thread thr;
    private  main main;

    public clientCustomerReadThread(main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getNetworkUtil().read();
                if (o != null) {
                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
//                        System.out.println(loginDTO.getUserName());
//                        System.out.println(loginDTO.isStatus());
                        if (loginDTO.isStatus()) {
                            try {
                                main.setUserName(loginDTO.getUserName());
                                main.showAllRestaurantDetails();
                            } catch (Exception e) {
//                                System.out.println("HI");
                                e.printStackTrace();
                            }
                        } else {
                            main.showAlert();
                        }
                    }
                    if(o instanceof Bill){
                        main.paySlip.add((Bill) o);
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


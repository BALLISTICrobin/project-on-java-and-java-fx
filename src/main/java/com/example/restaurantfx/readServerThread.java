package com.example.restaurantfx;



import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class readServerThread implements Runnable {
    private final Thread thr;
    private final SocketWrapper networkUtil;
    public HashMap<String, String> userMap;
    public HashMap<String, SocketWrapper> clientMap;


    public readServerThread(HashMap<String, String> map, SocketWrapper networkUtil, HashMap<String, SocketWrapper> clientMap) {
        this.clientMap = clientMap;
        this.userMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }





    public void run() {
        try {
            while (true) {

                Object o = networkUtil.read();
                if (o != null) {

                    if (o instanceof LoginDTO) {
                        LoginDTO loginDTO = (LoginDTO) o;
                        clientMap.put(loginDTO.getUserName(), networkUtil);
                        String password = userMap.get(loginDTO.getUserName());

                        loginDTO.setStatus(loginDTO.getPassword().equals(password));
//                        System.out.println(loginDTO.getPassword().equals(password));
                        networkUtil.write(loginDTO);
                    }
                    else if(o instanceof LoginDTR){
                        LoginDTR loginDTR = (LoginDTR) o;

                        String ID = userMap.get(loginDTR.getUserName());
                        clientMap.put(ID, networkUtil);

                        loginDTR.setStatus(loginDTR.getId().equals(ID));
                        System.out.println(loginDTR.getId().equals(ID));
                        networkUtil.write(loginDTR);
                    }

                    else if(o instanceof Order){

                        Order order = (Order) o;


                            SocketWrapper nu = clientMap.get(Integer.toString(order.getRestaurantId()));
                            if (nu != null) {

                                nu.write(order);
                            }

                    }
                    else if (o instanceof Bill) {
                        Bill obj = (Bill) o;
                        SocketWrapper nu = clientMap.get(obj.getUserName());
                        if(nu!=null){
                            nu.write(obj);
                        }
                    }

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}

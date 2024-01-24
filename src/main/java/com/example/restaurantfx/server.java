package com.example.restaurantfx;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class server {

    private ServerSocket serverSocket;
    public HashMap<String, String> userMap;
    public HashMap<String, SocketWrapper> clientMap;
    server() {
        userMap = new HashMap<>();
        clientMap = new HashMap<>();
        userMap.put("robin", "123");
        userMap.put("gourove", "234");
        userMap.put("abhishek", "345");
        userMap.put("niloy", "456");
        userMap.put("fatin", "567");

        userMap.put("KFC", "1");
        userMap.put("IHOP", "2");
        userMap.put("Starbucks","3");
        userMap.put("McDonalds", "4");

        try {
            serverSocket = new ServerSocket(33333);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }

    public void serve(Socket clientSocket) throws IOException {
        SocketWrapper socketWrapper = new SocketWrapper(clientSocket);
        new readServerThread(userMap, socketWrapper, clientMap);
    }

    public static void main(String[] args) {
        new server();
    }

}

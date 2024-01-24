package com.example.restaurantfx;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import java.io.IOException;

public class OrderExtended {
    private mainRestaurantManager main;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private int restaurantId;
    private String foodName;

    public int getRestaurantId() {
        return restaurantId;
    }
    private Bill bill;

    public OrderExtended(Order obj, mainRestaurantManager main) {
        this.main = main;
        this.restaurantId = obj.getRestaurantId();
        this.foodName = obj.getFoodName();
        this.quantity = obj.getQuantity();
        this.price = obj.getPrice();
        this.totalPrice = obj.getPrice();
        this.userName = obj.getUsername();
        this.button = new Button("Accept");
        this.button.setOnAction(this::foodAccepted);
    }

    private void foodAccepted(ActionEvent actionEvent)  {
        bill = new Bill(foodName,quantity,price,totalPrice,userName);
//        main.billList.add(bill);
        try {
            main.getNetworkUtil().write(bill);
            main.removeOrder(bill.getFoodName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.button.setDisable(true);
        this.button.setVisible(false);
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }



    private int quantity;
    private double price;

    private double totalPrice;

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }
    public void setMain(mainRestaurantManager main){
        this.main = main;
    }
    private Button button;

}

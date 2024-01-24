package com.example.restaurantfx;

import javafx.scene.text.Text;

import java.io.Serializable;

public class Bill implements Serializable {
    private String foodName;
    private int quantity;
    private double price;



    public Bill(String foodName, int quantity, double price, double totalPrice, String userName) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.userName = userName;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private double totalPrice;
    private String userName;

}

package com.example.restaurantfx;

import javafx.scene.control.Button;

import java.io.Serializable;

public class Order implements Serializable{

    private int restaurantId;

    private String username;

    private String foodName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private int quantity;
    private double price;

    private double totalPrice;



    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getRestaurantId() {
        return restaurantId;
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

    public Order(int restaurantId, String foodName, int quantity, double price) {

        this.restaurantId = restaurantId;
        this.foodName = foodName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = price*quantity;

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
}

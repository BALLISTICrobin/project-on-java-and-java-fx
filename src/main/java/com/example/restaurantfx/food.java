package com.example.restaurantfx;

public class food {
    private int restaurantId;
    private String foodCategory="";
    private String foodName ="";
    private double foodPrice;

    public food(){ }
    public food(int restaurantId, String foodCategory, String foodName, double foodPrice){
        this.restaurantId = restaurantId;
        this.foodCategory = foodCategory;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
    }
    public void setRestaurantId(int restaurantId)
    {
        this.restaurantId = restaurantId;
    }
    public void setFoodCategory(String foodCategory){
        this.foodCategory = foodCategory;
    }
    public void setFoodName(String foodName){
        this.foodName = foodName;
    }
    public void setFoodPrice(double foodPrice){
        this.foodPrice = foodPrice;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public String getFoodName() {
        return foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

}

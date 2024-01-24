package com.example.restaurantfx;

import java.util.List;

public class restaurantExtended {
    private  int id;
    private String restaurantName="";
    private double restaurantScore;
    private String restaurantPriceRange="";
    private int restaurantZipCode;
    private String restaurantCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getRestaurantScore() {
        return restaurantScore;
    }

    public void setRestaurantScore(double restaurantScore) {
        this.restaurantScore = restaurantScore;
    }

    public String getRestaurantPriceRange() {
        return restaurantPriceRange;
    }

    public void setRestaurantPriceRange(String restaurantPriceRange) {
        this.restaurantPriceRange = restaurantPriceRange;
    }

    public int getRestaurantZipCode() {
        return restaurantZipCode;
    }

    public void setRestaurantZipCode(int restaurantZipCode) {
        this.restaurantZipCode = restaurantZipCode;
    }

    public String getRestaurantCategory() {
        return restaurantCategory;
    }

    public void setRestaurantCategory(String restaurantCategory) {
        this.restaurantCategory = restaurantCategory;
    }

    public List<food> getRestaurantMenu() {
        return restaurantMenu;
    }

    public void setRestaurantMenu(List<food> restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
    }

    public int getFoodAdded() {
        return foodAdded;
    }

    public void setFoodAdded(int foodAdded) {
        this.foodAdded = foodAdded;
    }

    private List<food> restaurantMenu;
    private int foodAdded;

    restaurantExtended(restaurant obj){
        this.id = obj.getId();
        this.restaurantName = obj.getRestaurantName();
        this.restaurantScore = obj.getRestaurantScore();
        this.restaurantPriceRange = obj.getRestaurantPriceRange();
        this.restaurantZipCode = obj.getRestaurantZipCode();

        this.restaurantMenu = obj.getRestaurantMenu(); // Initialize the menu as an empty list
        this.foodAdded = obj.getFoodAdded(); // Initialize foodAdded to 0
        StringBuilder result = new StringBuilder();
        String[] cat = obj.getRestaurantCategory();
        for (int i = 0; i < cat.length; i++) {
            result.append(cat[i]);

            // Add a comma after each element except the last one
            if (i < cat.length - 1) {
                result.append(", ");
            }
        }

        this.restaurantCategory = result.toString();
    }
}

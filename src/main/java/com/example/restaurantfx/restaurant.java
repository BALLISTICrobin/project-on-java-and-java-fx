package com.example.restaurantfx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class restaurant {
    private  int id;
    private String restaurantName="";
    private double restaurantScore;
    private String restaurantPriceRange="";
    private int restaurantZipCode;
    private String[] restaurantCategory;

    private List<food> restaurantMenu;
    private int foodAdded;
    public restaurant(){ }
    public restaurant(int id,String restaurantName, double restaurantScore,String restaurantPriceRange,int restaurantZipCode,String[] restaurantCategories ) throws IOException {
        foodAdded = 0;
        FileOperation fileObj = new FileOperation();
        restaurantMenu = fileObj.returnFoodLog(id);
        restaurantCategory = new String[3];
        this.id = id;
        this.restaurantName = restaurantName;
        this.restaurantScore = restaurantScore;
        this.restaurantPriceRange = restaurantPriceRange;
        this.restaurantZipCode = restaurantZipCode;
        this.restaurantCategory = restaurantCategories;

    }

    public int getId() {
        return id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public double getRestaurantScore() {
        return restaurantScore;
    }

    public String getRestaurantPriceRange() {
        return restaurantPriceRange;
    }

    public int getRestaurantZipCode() {
        return restaurantZipCode;
    }

    public String[] getRestaurantCategory() {
        return restaurantCategory;
    }

    public List<food> getRestaurantMenu() {
        return restaurantMenu;
    }
    public int getFoodAdded() {
        return foodAdded;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public void setRestaurantZipCode(int restaurantZipCode) {
        this.restaurantZipCode = restaurantZipCode;
    }

    public void setRestaurantPriceRange(String restaurantPriceRange) {
        this.restaurantPriceRange = restaurantPriceRange;
    }

    public void setRestaurantScore(double restaurantScore) {
        this.restaurantScore = restaurantScore;
    }

    public void setRestaurantMenu(List<food> restaurantMenu) {
        this.restaurantMenu = restaurantMenu;
        this.foodAdded = restaurantMenu.size();
    }

    public void setRestaurantCategory(String[] restaurantCategory) {
        this.restaurantCategory = restaurantCategory;
    }

    public List<food> foodDetailsOnName(String name){
        List<food> foodList = new ArrayList<food>();
        for(var food:restaurantMenu){
            if(food!=null && food.getFoodName().toLowerCase().contains(name.toLowerCase())){
                foodList.add(food);
            }
        }
        if(foodList.isEmpty())
        {
            return null;
        }
        return foodList;
    }
    public List<food> foodDetailsOnFoodCategory(String category){
        List<food> foodList = new ArrayList<food>();
        for(var food:restaurantMenu){
            if(food!=null && food.getFoodCategory().toLowerCase().contains(category.toLowerCase())){
                foodList.add(food);
            }
        }
        if(foodList.isEmpty())
        {
            return null;
        }
        return foodList;
    }
    public List<food> foodDetailsOnFoodPriceRange(double minPrice, double maxPrice){
        List<food> foodList = new ArrayList<food>();
        for(var food:restaurantMenu){
            if(food!=null && minPrice<=food.getFoodPrice() && maxPrice>=food.getFoodPrice()){
                foodList.add(food);
            }
        }
        if(foodList.isEmpty())
        {
            return null;
        }
        return foodList;
    }
    public List<food> foodDetailsOnCostliestPrice(){
        List<food> foodList = new ArrayList<food>();
        double maxPrice = Integer.MIN_VALUE;
        for(var food:restaurantMenu){
            if(food!=null && food.getFoodPrice()>maxPrice){
                maxPrice = food.getFoodPrice();
            }
        }
        for(var food:restaurantMenu){
            if(food!=null && food.getFoodPrice()==maxPrice){
                foodList.add(food);
            }
        }
        if(foodList.isEmpty())
        {
            return null;
        }
        return foodList;
    }

    public boolean addFood(String foodName,String foodCategory, double foodPrice){
        for(var food: restaurantMenu){
            if(food!=null && food.getFoodName().equalsIgnoreCase(foodName) && food.getFoodCategory().equalsIgnoreCase(foodCategory)){
                return false;
            }
        }
        food foodObj = new food(this.id,foodCategory,foodName,foodPrice);
        restaurantMenu.add(foodObj);
        foodAdded++;
        return true;

    }



}


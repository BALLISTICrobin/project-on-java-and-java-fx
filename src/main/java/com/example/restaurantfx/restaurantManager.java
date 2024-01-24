package com.example.restaurantfx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class restaurantManager {
    private int restaurantAdded;
    private List<restaurant> restaurants;

    public List<restaurant> getRestaurants() {
        return restaurants;
    }

    public restaurantManager() throws IOException {
        restaurantAdded =0;
        FileOperation fileObj = new FileOperation();
        restaurants = fileObj.returnRestaurantLog();
    }
    public Map<String,Integer> showRestaurantTotalFoods(){
        Map<String,Integer> restaurantTotalFood = new HashMap<>();
        for(var restaurant: restaurants){
            if(restaurant!=null) {
                String name = restaurant.getRestaurantName();
                Integer totalFood = restaurant.getFoodAdded();
                restaurantTotalFood.put(name,totalFood);
            }
        }
        return restaurantTotalFood;
    }
    public List<List<food>> searchByName(String name){
        List<List<food>> foodList = new ArrayList<List<food>>();
        for(var restaurant: restaurants){
            if(restaurant!=null){
                if(restaurant.foodDetailsOnName(name)!=null){
                    foodList.add(restaurant.foodDetailsOnName(name));
                }
            }
        }
        if(!foodList.isEmpty()) {
            return foodList;
        }
        else
        {
            return null;
        }
    }
    public List<food> searchByNameForCertainRestaurant(String restName,String foodName){

        for(var restaurant: restaurants){
            if(restaurant!=null){
                if(restaurant.getRestaurantName().toLowerCase().contains(restName.toLowerCase())){

                    if(restaurant.foodDetailsOnName(foodName)!=null){
                        return restaurant.foodDetailsOnName(foodName);
                    }
                }
            }
        }
        return null;
    }
    public List<List<food>> searchByFoodCategory(String category){
        List<List<food>> foodList = new ArrayList<List<food>>();
        for(var restaurant: restaurants){
            if(restaurant!=null){
                if(restaurant.foodDetailsOnFoodCategory(category)!=null){
                    foodList.add(restaurant.foodDetailsOnFoodCategory(category));
                }
            }
        }
        if(!foodList.isEmpty()) {
            return foodList;
        }
        else
        {
            return null;
        }
    }
    public List<food> searchByCategoryForCertainRestaurant(String restName,String foodCategory){

        for(var restaurant: restaurants){
            if(restaurant!=null){
                if(restaurant.getRestaurantName().toLowerCase().contains(restName.toLowerCase())){
                    if(restaurant.foodDetailsOnFoodCategory(foodCategory)!=null){
                        return restaurant.foodDetailsOnFoodCategory(foodCategory);
                    }
                }
            }
        }
        return null;
    }
    public List<List<food>> searchByFoodPriceRange(double minPrice,double maxPrice){
        List<List<food>> foodList = new ArrayList<List<food>>();
        for(var restaurant: restaurants){
            if(restaurant!=null){
                if(restaurant.foodDetailsOnFoodPriceRange(minPrice,maxPrice)!=null){
                    foodList.add(restaurant.foodDetailsOnFoodPriceRange(minPrice,maxPrice));
                }
            }
        }
        if(!foodList.isEmpty()) {
            return foodList;
        }
        else
        {
            return null;
        }
    }
    public List<food> searchByPriceRangeForCertainRestaurant(String restName,double min, double max){

        for(var restaurant: restaurants){
            if(restaurant!=null){
                if(restaurant.getRestaurantName().toLowerCase().contains(restName.toLowerCase())){
                    if(restaurant.foodDetailsOnFoodPriceRange(min,max)!=null){
                        return restaurant.foodDetailsOnFoodPriceRange(min,max);
                    }
                }
            }
        }
        return null;
    }
    public List<food> costliestFoodForCertainRestaurant(String restName){

        for(var restaurant: restaurants){
            if(restaurant!=null){
                if(restaurant.getRestaurantName().equalsIgnoreCase(restName)){
                    if(restaurant.foodDetailsOnCostliestPrice()!=null){
                        return restaurant.foodDetailsOnCostliestPrice();
                    }
                }
            }
        }
        return null;
    }
    public restaurant searchRestaurantByName(String name){
        for(var restaurant: restaurants){
            if(restaurant!=null && restaurant.getRestaurantName().toLowerCase().contains(name.toLowerCase())){
                return restaurant;
            }
        }
        return null;
    }
    public List<restaurant> searchRestaurantByScore(double score){
        List<restaurant> restaurantByScore = new ArrayList<restaurant>();

        for(var restaurant: restaurants){
            if(restaurant!=null && restaurant.getRestaurantScore()==score){
                restaurantByScore.add(restaurant);
            }
        }
        if(!restaurantByScore.isEmpty()){
            return restaurantByScore;
        }
        else {
            return null;
        }
    }
    public List<restaurant> searchRestaurantByCategory(String restCategory){
        List<restaurant> restaurantByCategory = new ArrayList<restaurant>();
        for(var restaurant: restaurants){
            if(restaurant!=null){
                for(var category: restaurant.getRestaurantCategory())
                {
                    if(category!=null && category.toLowerCase().contains(restCategory.toLowerCase())){
                        restaurantByCategory.add(restaurant);
                        break;
                    }
                }
            }
        }
        if(!restaurantByCategory.isEmpty()){
            return restaurantByCategory;
        }
        else {
            return null;
        }

    }
    public List<restaurant> searchRestaurantByPrice(String restPrice){
        List<restaurant> restaurantByPrice = new ArrayList<restaurant>();

        for(var restaurant: restaurants){
            if(restaurant!=null && restaurant.getRestaurantPriceRange().equalsIgnoreCase(restPrice)){
                restaurantByPrice.add(restaurant);
            }
        }
        if(!restaurantByPrice.isEmpty()){
            return restaurantByPrice;
        }
        else {
            return null;
        }
    }

    public List<restaurant> searchRestaurantByZip(int zipCode){
        List<restaurant> restaurantByZipCode = new ArrayList<restaurant>();

        for(var restaurant: restaurants){
            if(restaurant!=null && restaurant.getRestaurantZipCode()==zipCode){
                restaurantByZipCode.add(restaurant);
            }
        }
        if(!restaurantByZipCode.isEmpty()){
            return restaurantByZipCode;
        }
        else {
            return null;
        }
    }

    public Map<String,List<String>> categoryWiseLists(){
        Map<String,List<String>> categoryWiseRestaurants = new HashMap<String,List<String>>();
        for(var restaurant:restaurants){
            if(restaurant!=null){
                for(var category:restaurant.getRestaurantCategory()){
                    if(category!=null){

                        categoryWiseRestaurants.computeIfAbsent(category.toLowerCase(), key -> new ArrayList<>()).add(restaurant.getRestaurantName());

                    }
                }
            }
        }
        if(!categoryWiseRestaurants.isEmpty()){
            return categoryWiseRestaurants;
        }
        else
            return null;
    }

    public boolean addRestaurant(int id,String name,double score,String priceRange,int zipCode, String[]categories) throws IOException {
        for(var restaurant: restaurants){
            if(restaurant!=null && restaurant.getRestaurantName().equalsIgnoreCase(name) && restaurant.getId()==id){
                return false;
            }
        }
        restaurant restObj =new restaurant(id,name,score,priceRange,zipCode,categories);
        restaurants.add(restObj);
        restaurantAdded++;
        return true;
    }

    public boolean addFoodItemsToRestaurant(String restName,String foodName, String foodCategory,double foodPrice){
        for(var restaurant:restaurants){
            if(restaurant!=null && restaurant.getRestaurantName().equalsIgnoreCase(restName)){
                return restaurant.addFood(foodName,foodCategory,foodPrice);
            }
        }
        return false;
    }
    public boolean savedModifiedText() throws IOException {
        FileOperation fileObj = new FileOperation();
        return fileObj.savedBackRestaurantText(restaurants);
    }
}

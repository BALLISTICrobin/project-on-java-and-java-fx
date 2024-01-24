package com.example.restaurantfx;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class restaurantDatabase {

    public static void main(String[]args) throws IOException {
        restaurantManager restaurantManagerObj;
        restaurantManagerObj = new restaurantManager();
        System.out.println("WELCOME TO RESTAURANT DATABASE SYSTEM!!");
        int choice,subChoice;
        double foodPriceMin,foodPriceMax;
        String Restaurant, Food,cat;
        restaurant obj;
        List<restaurant> restList;
        List<food> FoodList;
        List<List<food>> FoodListList;
        String[] category ;
        Map<String,List<String>> categoryList;
        Map<String,Integer> totalFoodsPerRestaurants;
        int id;
       String restaurantName;
       double restaurantScore;
        String restaurantPriceRange;
        int restaurantZipCode;
       String[] restaurantCategory;

         String foodCategory;
         String foodName;
         double foodPrice;
        Scanner in = new Scanner(System.in);
        do{
            System.out.println("MAIN MENU: ");
            System.out.println("(1) Search Restaurants");
            System.out.println("2) Search Food Items");
            System.out.println("3) Add Restaurant");
            System.out.println("4) Add Food Item to the Menu");
            System.out.println("5) Exit System");
            System.out.print("Enter Your Choice: ");
            choice = Integer.parseInt(in.nextLine());

            switch (choice) {
                case 1 -> {
                    do {
                        System.out.println("Restaurant Searching Options:");

                        System.out.println("1) By Name");
                        System.out.println("2) By Score");
                        System.out.println("3) By Category");
                        System.out.println("4) By Price");
                        System.out.println("5) By Zip Code");
                        System.out.println("6) Different Category Wise List of Restaurants");
                        System.out.println("7) Back to Main Menu");
                        System.out.print("Enter Your Choice: ");
                        subChoice = Integer.parseInt(in.nextLine());

                        switch (subChoice) {
                            case 1 -> {
                                System.out.println("enter restaurant name: ");
                                obj = restaurantManagerObj.searchRestaurantByName(in.nextLine());
                                if (obj != null) {
                                    System.out.println("Restaurant Id: " + obj.getId());
                                    System.out.println("Restaurant name: " + obj.getRestaurantName());
                                    System.out.println("Restaurant Rating: " + obj.getRestaurantScore());
                                    System.out.println("Restaurant Price($/$$/$$$): " + obj.getRestaurantPriceRange());
                                    System.out.println("Restaurant ZipCode: " + obj.getRestaurantZipCode());
                                    System.out.print("Restaurant Categories: ");
                                    category = obj.getRestaurantCategory();
                                    if (category != null) {
                                        for (int index = 0; index < category.length; index++) {
                                            if (category[index] != null) {
                                                System.out.print(category[index]);
                                                if (index != 2) {
                                                    System.out.print(",");
                                                }
                                            }
                                        }
                                        System.out.println();
                                    }
                                } else {
                                    System.out.println("No such restaurant with this name");
                                }
                            }
                            case 2 -> {
                                System.out.println("enter rating for the restaurant:");
                                restList = restaurantManagerObj.searchRestaurantByScore(Double.parseDouble(in.nextLine()));
                                if (restList != null) {
                                    for (var restaurant : restList) {
                                        if (restaurant != null) {
                                            System.out.println("Restaurant Id: " + restaurant.getId());
                                            System.out.println("Restaurant name: " + restaurant.getRestaurantName());
                                            System.out.println("Restaurant Rating: " + restaurant.getRestaurantScore());
                                            System.out.println("Restaurant Price($/$$/$$$): " + restaurant.getRestaurantPriceRange());
                                            System.out.println("Restaurant ZipCode: " + restaurant.getRestaurantZipCode());
                                            System.out.print("Restaurant Categories: ");
                                            category = restaurant.getRestaurantCategory();
                                            if (category != null) {
                                                for (int index = 0; index < category.length; index++) {
                                                    if (category[index] != null) {
                                                        System.out.print(category[index]);
                                                        if (index != 2) {
                                                            System.out.print(",");
                                                        }
                                                    }
                                                }
                                                System.out.println();
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("No such restaurant with this score range");
                                }
                            }
                            case 3 -> {
                                System.out.println("enter category: ");
                                restList = restaurantManagerObj.searchRestaurantByCategory(in.nextLine());
                                if (restList != null) {
                                    for (var restaurant : restList) {
                                        if (restaurant != null) {
                                            System.out.println("Restaurant Id: " + restaurant.getId());
                                            System.out.println("Restaurant name: " + restaurant.getRestaurantName());
                                            System.out.println("Restaurant Rating: " + restaurant.getRestaurantScore());
                                            System.out.println("Restaurant Price($/$$/$$$): " + restaurant.getRestaurantPriceRange());
                                            System.out.println("Restaurant ZipCode: " + restaurant.getRestaurantZipCode());
                                            System.out.print("Restaurant Categories: ");
                                            category = restaurant.getRestaurantCategory();
                                            if (category != null) {
                                                for (int index = 0; index < category.length; index++) {
                                                    if (category[index] != null) {
                                                        System.out.print(category[index]);
                                                        if (index != 2) {
                                                            System.out.print(",");
                                                        }
                                                    }
                                                }
                                                System.out.println();
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("No such restaurant with this category");
                                }
                            }
                            case 4 -> {
                                System.out.println("enter price range of the restaurant: ");
                                restList = restaurantManagerObj.searchRestaurantByPrice(in.nextLine());
                                if (restList != null) {
                                    for (var restaurant : restList) {
                                        if (restaurant != null) {
                                            System.out.println("Restaurant Id: " + restaurant.getId());
                                            System.out.println("Restaurant name: " + restaurant.getRestaurantName());
                                            System.out.println("Restaurant Rating: " + restaurant.getRestaurantScore());
                                            System.out.println("Restaurant Price($/$$/$$$): " + restaurant.getRestaurantPriceRange());
                                            System.out.println("Restaurant ZipCode: " + restaurant.getRestaurantZipCode());
                                            System.out.print("Restaurant Categories: ");
                                            category = restaurant.getRestaurantCategory();
                                            if (category != null) {
                                                for (int index = 0; index < category.length; index++) {
                                                    if (category[index] != null) {
                                                        System.out.print(category[index]);
                                                        if (index != 2) {
                                                            System.out.print(",");
                                                        }
                                                    }
                                                }
                                                System.out.println();
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("No such restaurant with this price");
                                }
                            }
                            case 5 -> {
                                System.out.println("enter zip code of the restaurant: ");
                                restList = restaurantManagerObj.searchRestaurantByZip(Integer.parseInt(in.nextLine()));
                                if (restList != null) {
                                    for (var restaurant : restList) {
                                        if (restaurant != null) {
                                            System.out.println("Restaurant Id: " + restaurant.getId());
                                            System.out.println("Restaurant name: " + restaurant.getRestaurantName());
                                            System.out.println("Restaurant Rating: " + restaurant.getRestaurantScore());
                                            System.out.println("Restaurant Price($/$$/$$$): " + restaurant.getRestaurantPriceRange());
                                            System.out.println("Restaurant ZipCode: " + restaurant.getRestaurantZipCode());
                                            System.out.print("Restaurant Categories: ");
                                            category = restaurant.getRestaurantCategory();
                                            if (category != null) {
                                                for (int index = 0; index < category.length; index++) {
                                                    if (category[index] != null) {
                                                        System.out.print(category[index]);
                                                        if (index != 2) {
                                                            System.out.print(",");
                                                        }
                                                    }
                                                }
                                                System.out.println();
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("No such restaurant with this zip code");
                                }
                            }
                            case 6 -> {
                                categoryList = restaurantManagerObj.categoryWiseLists();
                                System.out.println("Category Wise Restaurant List: ");
                                if (categoryList != null) {
                                    for (var categoryWiseList : categoryList.entrySet()) {
                                        if (categoryWiseList != null) {
                                            System.out.println(categoryWiseList.getKey() + " : " + String.join(",", categoryWiseList.getValue()));

                                        }
                                    }
                                }
                            }
                            case 7 -> System.out.println("Going to main menu");
                            default -> System.out.println("Invalid Input");// : McDonalds
                        }
                    } while (subChoice != 7);
                }
                case 2 -> {
                    do {
                        System.out.println("Food Item Searching Options: ");
                        System.out.println("1) By Name");
                        System.out.println("2) By Name in a Given Restaurant");
                        System.out.println("3) By Category");
                        System.out.println("4) By Category in a Given Restaurant");
                        System.out.println("5) By Price Range");
                        System.out.println("6) By Price Range in a Given Restaurant");
                        System.out.println("7) Costliest Food Item(s) on the Menu in a Given Restaurant");
                        System.out.println("8) List of Restaurants and Total Food Item on the Menu");
                        System.out.println("9) Back to Main Menu");
                        System.out.println("enter your choice: ");
                        subChoice = Integer.parseInt(in.nextLine());
                        switch (subChoice) {
                            case 1 -> {
                                System.out.println("enter name of food:");
                                FoodListList = restaurantManagerObj.searchByName(in.nextLine());
                                if (FoodListList != null) {
                                    for (var foodList : FoodListList) {
                                        if (foodList != null) {
                                            for (var food : foodList) {
                                                if (food != null) {
                                                    System.out.println("Restaurant Id: " + food.getRestaurantId());
                                                    System.out.println("Food Name: " + food.getFoodName());
                                                    System.out.println("Food Category: " + food.getFoodCategory());
                                                    System.out.println("Food Price: " + food.getFoodPrice());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("No such food item with this name");
                                }
                            }
                            case 2 -> {
                                System.out.println("enter restaurant name: ");
                                Restaurant = in.nextLine();
                                System.out.println("enter food name: ");
                                Food = in.nextLine();
                                FoodList = restaurantManagerObj.searchByNameForCertainRestaurant(Restaurant, Food);
                                if (FoodList != null) {
                                    for (var food : FoodList) {
                                        if (food != null) {
                                            System.out.println("Restaurant Id: " + food.getRestaurantId());
                                            System.out.println("Food Name: " + food.getFoodName());
                                            System.out.println("Food Category: " + food.getFoodCategory());
                                            System.out.println("Food Price: " + food.getFoodPrice());
                                        }
                                    }
                                } else {
                                    System.out.println("No such food item with this name on the menu of this restaurant");
                                }
                            }
                            case 3 -> {
                                System.out.println("enter category of food:");
                                FoodListList = restaurantManagerObj.searchByFoodCategory(in.nextLine());
                                if (FoodListList != null) {
                                    for (var foodList : FoodListList) {
                                        if (foodList != null) {
                                            for (var food : foodList) {
                                                if (food != null) {
                                                    System.out.println("Restaurant Id: " + food.getRestaurantId());
                                                    System.out.println("Food Name: " + food.getFoodName());
                                                    System.out.println("Food Category: " + food.getFoodCategory());
                                                    System.out.println("Food Price: " + food.getFoodPrice());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("No such food item with this category");
                                }
                            }
                            case 4 -> {
                                System.out.println("enter restaurant name: ");
                                Restaurant = in.nextLine();
                                System.out.println("enter food category: ");
                                Food = in.nextLine();
                                FoodList = restaurantManagerObj.searchByCategoryForCertainRestaurant(Restaurant, Food);
                                if (FoodList != null) {
                                    for (var food : FoodList) {
                                        if (food != null) {
                                            System.out.println("Restaurant Id: " + food.getRestaurantId());
                                            System.out.println("Food Name: " + food.getFoodName());
                                            System.out.println("Food Category: " + food.getFoodCategory());
                                            System.out.println("Food Price: " + food.getFoodPrice());
                                        }
                                    }
                                } else {
                                    System.out.println("No such food item with this category on the menu of this restaurant");
                                }
                            }
                            case 5 -> {
                                System.out.println("enter minimum price for food:");
                                foodPriceMin = Double.parseDouble(in.nextLine());
                                System.out.println("enter maximum price for food:");
                                foodPriceMax = Double.parseDouble(in.nextLine());
                                FoodListList = restaurantManagerObj.searchByFoodPriceRange(foodPriceMin, foodPriceMax);
                                if (FoodListList != null) {
                                    for (var foodList : FoodListList) {
                                        if (foodList != null) {
                                            for (var food : foodList) {
                                                if (food != null) {
                                                    System.out.println("Restaurant Id: " + food.getRestaurantId());
                                                    System.out.println("Food Name: " + food.getFoodName());
                                                    System.out.println("Food Category: " + food.getFoodCategory());
                                                    System.out.println("Food Price: " + food.getFoodPrice());
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("No such food item with this price range");
                                }
                            }
                            case 6 -> {
                                System.out.println("enter restaurant name: ");
                                Restaurant = in.nextLine();
                                System.out.println("enter minimum price for food:");
                                foodPriceMin = Double.parseDouble(in.nextLine());
                                System.out.println("enter maximum price for food:");
                                foodPriceMax = Double.parseDouble(in.nextLine());
                                FoodList = restaurantManagerObj.searchByPriceRangeForCertainRestaurant(Restaurant, foodPriceMin, foodPriceMax);
                                if (FoodList != null) {
                                    for (var food : FoodList) {
                                        if (food != null) {
                                            System.out.println("Restaurant Id: " + food.getRestaurantId());
                                            System.out.println("Food Name: " + food.getFoodName());
                                            System.out.println("Food Category: " + food.getFoodCategory());
                                            System.out.println("Food Price: " + food.getFoodPrice());
                                        }
                                    }
                                } else {
                                    System.out.println("No such food item with this price range on the menu of this restaurant");
                                }
                            }
                            case 7 -> {
                                System.out.println("enter restaurant name: ");
                                Restaurant = in.nextLine();
                                FoodList = restaurantManagerObj.costliestFoodForCertainRestaurant(Restaurant);
                                if (FoodList != null) {
                                    for (var food : FoodList) {
                                        if (food != null) {
                                            System.out.println("Restaurant Id: " + food.getRestaurantId());
                                            System.out.println("Food Name: " + food.getFoodName());
                                            System.out.println("Food Category: " + food.getFoodCategory());
                                            System.out.println("Food Price: " + food.getFoodPrice());
                                        }
                                    }
                                }
                            }
                            case 8 -> {
//                                totalFoodsPerRestaurants = new HashMap<String, Integer>();
                                totalFoodsPerRestaurants = restaurantManagerObj.showRestaurantTotalFoods();
                                if (totalFoodsPerRestaurants != null) {
                                    System.out.println("Number of Total foods per Restaurant: ");
                                    for (var foodPerRest : totalFoodsPerRestaurants.entrySet()) {
                                        System.out.println(foodPerRest.getKey() + " : " + foodPerRest.getValue());
                                    }
                                }
                            }
                            case 9 -> System.out.println("Going back to main menu");
                            default -> System.out.println("invalid input");
                        }
                    } while (subChoice != 9);
                }
                case 3 -> {
                    System.out.println("Enter Id of the restaurant: ");
                    id = Integer.parseInt(in.nextLine());
                    System.out.println("Enter name of the restaurant: ");
                    restaurantName = in.nextLine();
                    System.out.println("Enter ratings of the restaurant: ");
                    restaurantScore = Double.parseDouble(in.nextLine());
                    System.out.println("Enter price range of the restaurant: ");
                    restaurantPriceRange = in.nextLine();
                    System.out.println("Enter Zip Code of the restaurant: ");
                    restaurantZipCode = Integer.parseInt(in.nextLine());
                    System.out.println("Enter number of categories of the restaurant: ");
                    restaurantCategory = new String[3];
                    int numOfCategory = Integer.parseInt(in.nextLine());
                    if (numOfCategory >= 1 && numOfCategory <= 3) {
                        System.out.println("enter the categories: ");
                        for (int i = 0; i < numOfCategory; i++) {
                            cat = in.nextLine();
                            restaurantCategory[i] = cat;
                        }
                    } else {
                        System.out.println("invalid number of categories.");
                        continue;
                    }
                    boolean done = restaurantManagerObj.addRestaurant(id, restaurantName, restaurantScore, restaurantPriceRange, restaurantZipCode, restaurantCategory);
                    if (done) {
                        System.out.println("restaurant is added successfully");
                    } else {
                        System.out.println("error in adding restaurant");
                    }
                }
                case 4 -> {
                    System.out.println("Enter name of the restaurant: ");
                    restaurantName = in.nextLine();
                    System.out.println("enter category of the food: ");
                    foodCategory = in.nextLine();
                    System.out.println("Enter name of the food: ");
                    foodName = in.nextLine();
                    System.out.println("enter food price: ");
                    foodPrice = Double.parseDouble(in.nextLine());
                    boolean done2 = restaurantManagerObj.addFoodItemsToRestaurant(restaurantName, foodName, foodCategory, foodPrice);
                    if (done2) {
                        System.out.println("food added in that restaurant successfully");
                    } else {
                        System.out.println("error in adding food in restaurant");
                    }
                }
                case 5 ->{
                    if(restaurantManagerObj.savedModifiedText())
                     System.out.println("saved back");
                    else
                        System.out.println("error in saved back file");
                    break;
                }
                default -> {
                    System.out.println("invalid input");
                }
            }
        }while(choice!=5);
    }
}

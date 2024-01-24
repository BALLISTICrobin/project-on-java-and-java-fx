package com.example.restaurantfx;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileOperation {
    private static final String INPUT_FILE_NAME1 = "restaurant.txt";
    private static final String INPUT_FILE_NAME2 = "menu.txt";
    private static final String OUTPUT_FILE_NAME1 = "restaurant.txt";
    private static final String OUTPUT_FILE_NAME2 = "menu.txt";
    public List<restaurant> returnRestaurantLog() throws IOException {
       List<restaurant> restaurantLog = new ArrayList<restaurant>();
       String[] restaurantInfo;
       BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME1));
       while(true){
           String line = br.readLine();
            if(line==null){
                restaurantInfo = new String[0];
                break;
            }
           restaurantInfo = line.split(",");
            if(restaurantInfo.length<6 || restaurantInfo.length>8){
                System.out.println(line + " is invalid");
                continue;
            }
            restaurant rest = new restaurant();
            rest.setId(Integer.parseInt(restaurantInfo[0]));
            rest.setRestaurantName(restaurantInfo[1]);
            rest.setRestaurantScore(Double.parseDouble(restaurantInfo[2]));
            rest.setRestaurantPriceRange(restaurantInfo[3]);
            rest.setRestaurantZipCode(Integer.parseInt(restaurantInfo[4]));
//           FileOperation fileObj = new FileOperation();

            rest.setRestaurantMenu(returnFoodLog(Integer.parseInt(restaurantInfo[0])));
            String[] cat = new String[3];
            int k = 0;
            for(int i=5;i<restaurantInfo.length;i++){
                if(restaurantInfo[i]!=null) {
                    cat[k++] = restaurantInfo[i];
                }
            }
            rest.setRestaurantCategory(cat);
            restaurantLog.add(rest);

       }
       br.close();
       return restaurantLog;
    }

    public List<food> returnFoodLog(int restId) throws IOException {
        List<food> foodLog = new ArrayList<food>();
        String[] foodInfo;
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME2));
        while(true){
            String line = br.readLine();
            if(line==null){
              foodInfo = new String[0];
                break;
            }
            foodInfo = line.split(",",-1);
            if(foodInfo.length>4){
                System.out.println(line + " is invalid");
                continue;
            }
            food Food = new food();
            if(Integer.parseInt(foodInfo[0])==restId){
                Food.setRestaurantId(Integer.parseInt(foodInfo[0]));
                Food.setFoodCategory(foodInfo[1]);
                Food.setFoodName(foodInfo[2]);
                Food.setFoodPrice(Double.parseDouble(foodInfo[3]));
                foodLog.add(Food);
            }
        }
        return foodLog;

    }
    public boolean savedBackRestaurantText(List<restaurant> restaurantLog) throws IOException {
        BufferedWriter bwRestaurant = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME1));
        BufferedWriter bwMenu = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME2));
        boolean menu = false;
        for(var restLog: restaurantLog){
            if(restLog!=null){
                int countCat=0;
                menu = savedBackRestaurantMenuText(restLog.getRestaurantMenu(),bwMenu);
                bwRestaurant.write(restLog.getId()+","+restLog.getRestaurantName()+","+restLog.getRestaurantScore()+","+restLog.getRestaurantPriceRange()+","+restLog.getRestaurantZipCode());
                for(var cat: restLog.getRestaurantCategory()){
                    if(cat!=null) {
                        countCat++;
                        bwRestaurant.write("," + cat);
                    }
                }
                if(countCat==1)
                    bwRestaurant.write(",,");
                if(countCat==2)
                    bwRestaurant.write(",");
                bwRestaurant.newLine();
            }
        }
        bwRestaurant.close();
        bwMenu.close();
        return menu;
    }
    public boolean savedBackRestaurantMenuText(List<food> foodLog, BufferedWriter bwMenu) throws IOException {
//        BufferedWriter bwMenu = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME2,true));
        for(var food:foodLog){
            if(food!=null){
                bwMenu.write(food.getRestaurantId()+","+food.getFoodCategory()+","+food.getFoodName()+","+food.getFoodPrice());
                bwMenu.newLine();
            }
        }

        return true;
    }

}

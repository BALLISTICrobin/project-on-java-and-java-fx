package com.example.restaurantfx;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class showRestaurantDetailsFromClientController  {
   @FXML
    private Button back;

    @FXML
    private  Button order;
    @FXML
    private Button logOut;
    private main Main;
    @FXML
    private TableView<food> tableView;
    @FXML
    private TableColumn<food, Integer> idRes;
    @FXML
    private TableColumn<food, String> catCol;
    @FXML
    private TableColumn<food, String> nameCol;
    @FXML
    private TableColumn<food, Double> priceCol;


    public void initializeColumns() {
        // Initialize the TableView columns
//        restaurantId = new TableColumn<>("Restaurant ID");
//        FoodCategory = new TableColumn<>("Food Category");
//        FoodName = new TableColumn<>("Food Name");
//        FoodPrice = new TableColumn<>("Food Price");
        idRes.setCellValueFactory(new PropertyValueFactory<>("restaurantId"));
        catCol.setCellValueFactory(new PropertyValueFactory<>("foodCategory"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("foodPrice"));
//        tableView.getColumns().addAll(restaurantId, FoodCategory, FoodName, FoodPrice);

        // Load data from the menu.txt file and populate the TableView
        ObservableList<food> foodItems = loadFoodItemsFromMenuFile();
        tableView.setEditable(true);
        tableView.setItems( foodItems);
    }

    public void load() {
        initializeColumns();
    }
    // Method to read data from the menu.txt file and return a list of FoodItem objects
    private ObservableList<food> loadFoodItemsFromMenuFile() {
        ObservableList<food> foodItems = FXCollections.observableArrayList();
        try {
            String[] foodInfo;
            BufferedReader br = new BufferedReader(new FileReader("menu.txt"));
            while (true) {
                String line = br.readLine();
                if (line == null) {
                    foodInfo = new String[0];
                    break;
                }
                foodInfo = line.split(",", -1);
                if (foodInfo.length > 4) {
//                    System.out.println(line + " is invalid");
                    continue;
                }
                food Food = new food();

                    Food.setRestaurantId(Integer.parseInt(foodInfo[0]));
                    Food.setFoodCategory(foodInfo[1]);
                    Food.setFoodName(foodInfo[2]);
                    Food.setFoodPrice(Double.parseDouble(foodInfo[3]));
                    foodItems.add(Food);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return foodItems;
    }
    public void setMain(main main) {
        this.Main = main;
    }


    public void goBack(ActionEvent actionEvent) throws Exception {
        Main.showClientLoginPage();
    }

    public void loggingOut(ActionEvent actionEvent) throws Exception {
        Main.showClientLoginPage();
    }



    public void searchFood(ActionEvent actionEvent) {
        Main.showSearchPage();
    }


}


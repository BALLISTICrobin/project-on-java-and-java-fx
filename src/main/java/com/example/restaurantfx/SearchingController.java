package com.example.restaurantfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;



public class SearchingController {

    @FXML
    private Button back;
    @FXML
    private Button logout;
    private main main;

    @FXML
    private SplitMenuButton searchSplitButton;
    @FXML
    public void initialize() {
        // Create menu items for "Restaurant" and "Food"
        MenuItem restaurantItem = new MenuItem("Restaurant");
        MenuItem foodItem = new MenuItem("Food");
        searchSplitButton.getItems().addAll(restaurantItem, foodItem);

        // Add action listeners for menu items
        restaurantItem.setOnAction(this::handleRestaurantItemClick);
        foodItem.setOnAction(this::handleFoodItemClick);



    }
    private void handleRestaurantItemClick(ActionEvent event) {
        // Handle the "Restaurant" menu item click here
        System.out.println("Clicked on Restaurant");
        main.showSearchFoodByRestaurant();
    }

    private void handleFoodItemClick(ActionEvent event) {
        // Handle the "Food" menu item click here
        System.out.println("Clicked on Food");
        main.showSearchFoodPage();
    }

    public void setMain(main main) {
        this.main = main;
    }

    public void GoingBack(ActionEvent actionEvent) {
        main.showAllRestaurantDetails();
    }

    public void LogginOut(ActionEvent actionEvent) throws Exception {
        main.showClientLoginPage();;
    }


    public void searchBy(ActionEvent actionEvent) {
        initialize();

    }
}

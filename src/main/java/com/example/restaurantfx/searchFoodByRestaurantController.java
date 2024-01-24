package com.example.restaurantfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.util.List;

public class searchFoodByRestaurantController {

    @FXML
    public TextField restaurantNameText;
    public Button cart;
    public Button orderStatus;
    private main main;

    @FXML
    private TableView<foodExtended> FoodListTableView;

    @FXML
    private TableColumn<foodExtended,Double> PriceCol;

    @FXML
    private TableColumn<foodExtended, Button> addCol;

    @FXML
    private TableColumn<foodExtended,String> CatCol;

    @FXML
    private TableColumn<foodExtended,Spinner<Integer>> quantityCol;

    @FXML
    private TextField foodCategory;

    @FXML
    private TextField foodMaxPrice;

    @FXML
    private TextField foodMinPrice;

    @FXML
    private TextField foodName;

    @FXML
    private TableColumn<foodExtended, Integer> idCol;

    @FXML
    private Button logOut;
    @FXML
    private Button Back;


    @FXML
    private TableColumn<foodExtended,String> nameCol;

    @FXML
    private TableColumn<foodExtended,Button> rmvCol;

    @FXML
    private Button searchByFoodCat;

    @FXML
    private Button searchByFoodName;

    @FXML
    private Button searchByFoodPrice;

    private restaurantManager restaurantManagerObj;

    public void initializeColumns(int flag) throws IOException {
        restaurantManagerObj=new restaurantManager();
        cart.setGraphic(new ImageView("file:src/main/resources/images/cart.png"));
        idCol.setCellValueFactory(new PropertyValueFactory<>("restaurantId"));
        CatCol.setCellValueFactory(new PropertyValueFactory<>("foodCategory"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        PriceCol.setCellValueFactory(new PropertyValueFactory<>("foodPrice"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("numberSpinner"));
        addCol.setCellValueFactory(new PropertyValueFactory<>("addToCart"));
        rmvCol.setCellValueFactory(new PropertyValueFactory<>("removeOrder"));



        if(flag==1) {
            ObservableList<foodExtended> foodItems = loadFoodItemsByName();
            FoodListTableView.setEditable(true);
            FoodListTableView.setItems(foodItems);
        }

        else if(flag ==2){
            ObservableList<foodExtended> foodItems = loadFoodItemsByCategory();
            FoodListTableView.setEditable(true);
            FoodListTableView.setItems(foodItems);

        }
        else if(flag == 3){
            ObservableList<foodExtended> foodItems = loadFoodItemsByPrice();
            FoodListTableView.setEditable(true);
            FoodListTableView.setItems(foodItems);

        }
    }

    public ObservableList<foodExtended> loadFoodItemsByPrice() {
        ObservableList<foodExtended> foodItems = FXCollections.observableArrayList();
        String restName = restaurantNameText.getText();
        double minPrice = Double.parseDouble(foodMinPrice.getText());
        double maxPrice = Double.parseDouble(foodMaxPrice.getText());
        try {
            List<food> foodList = restaurantManagerObj.searchByPriceRangeForCertainRestaurant(restName, minPrice, maxPrice);
            for (var foodItem : foodList) {
                if (foodItem != null) {

                    foodItems.add(new foodExtended(foodItem, main));
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return foodItems;


    }

    public ObservableList<foodExtended> loadFoodItemsByCategory() {
        ObservableList<foodExtended> foodItems = FXCollections.observableArrayList();
        String restName = restaurantNameText.getText();
        String cat = foodCategory.getText();
        try {
            List<food> foodList = restaurantManagerObj.searchByCategoryForCertainRestaurant(restName, cat);
            for (var foodItem : foodList) {
                if (foodItem != null) {

                    foodItems.add(new foodExtended(foodItem, main));

                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return foodItems;
    }

    public ObservableList<foodExtended> loadFoodItemsByName() {
        ObservableList<foodExtended> foodItems = FXCollections.observableArrayList();
        String restName = restaurantNameText.getText();
        String name = foodName.getText();
        try {
            List<food> foodList = restaurantManagerObj.searchByNameForCertainRestaurant(restName, name);
            for (var foodItem : foodList) {
                if (foodItem != null) {
                    foodItems.add(new foodExtended(foodItem, main));

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return foodItems;
    }


    @FXML
    void LoggingOut(ActionEvent event) throws Exception {

        main.showClientLoginPage();
        main.OrderList.clear();
    }

    @FXML
    void goingback(ActionEvent event) {
        main.showSearchPage();
        main.OrderList.clear();
    }

    @FXML
    void searchCat(ActionEvent event) throws IOException {
        initializeColumns(2);
        searchByFoodName.setVisible(false);
        searchByFoodName.setDisable(true);
        searchByFoodPrice.setVisible(false);
        searchByFoodPrice.setDisable(true);

    }

    @FXML
    void searchName(ActionEvent event) throws IOException {
        initializeColumns(1);
        searchByFoodCat.setVisible(false);
        searchByFoodCat.setDisable(true);
        searchByFoodPrice.setVisible(false);
        searchByFoodPrice.setDisable(true);
    }

    @FXML
    void searchPrice(ActionEvent event) throws IOException {
        initializeColumns(3);
        searchByFoodCat.setVisible(false);
        searchByFoodCat.setDisable(true);
        searchByFoodName.setVisible(false);
        searchByFoodName.setDisable(true);
    }



    public void setMain(main Main){
        this.main = Main;
    }

    public void ViewCart(ActionEvent actionEvent) {
        main.showCartPageByRest();
    }

    public void orderStatus(ActionEvent actionEvent) {
        main.showOrderStatusPageByRest();
    }
}

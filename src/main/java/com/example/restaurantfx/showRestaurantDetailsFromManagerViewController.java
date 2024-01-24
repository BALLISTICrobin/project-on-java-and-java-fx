package com.example.restaurantfx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class showRestaurantDetailsFromManagerViewController {

    public Button back;
    public Button logOut;
    public Button showFoods;
    public TableView<OrderExtended> OrderTableView;

    public TableColumn<OrderExtended,String> foodName;

    public TableColumn<OrderExtended,Double> foodPrice;
    public TableColumn<OrderExtended,Button> Accepted;
    public TableColumn<OrderExtended,Double> totalFoodPrice;
    public TableColumn<OrderExtended,Integer> quantity;
    public TableColumn<OrderExtended,Integer> idRestaurantCol;
    public TableColumn<OrderExtended,String> customerName;
    public Button deliver;

    private mainRestaurantManager main;
    @FXML
    private TableColumn<food,Integer> FIDCol;
    @FXML
    private Button orderList;
    @FXML
    private TableColumn<food, String> FCCol;

    @FXML
    private TableColumn<food,String> FNCol;

    @FXML
    private TableColumn<food,Double> FPCol;

    @FXML
    private TableView<food> FoodListTable;





    @FXML
    private TableColumn<restaurantExtended, String> catCol;







    @FXML
    private TableColumn<restaurantExtended,Integer> idCol;

    @FXML
    private TableColumn<restaurantExtended, String> nameCol;

    @FXML
    private TableColumn<restaurantExtended, String> priceCol;

    @FXML
    private TableView<restaurantExtended> restaurantTableView;

    @FXML
    private TableColumn<restaurantExtended,Double> scoreCol;

    @FXML
    private TableColumn<restaurantExtended,Integer> zipCol;
    private restaurantManager restaurantManagerObj;
    private restaurant restaurantObj;

    public void load() throws IOException {
        initializeColumns();
        initializeColumns2();
        new updateOrderViewThread(this);
    }

    private void initializeColumns2() throws IOException{


            FIDCol.setCellValueFactory(new PropertyValueFactory<>("restaurantId"));
            FCCol.setCellValueFactory(new PropertyValueFactory<>("foodCategory"));
            FNCol.setCellValueFactory(new PropertyValueFactory<>("foodName"));
            FPCol.setCellValueFactory(new PropertyValueFactory<>("foodPrice"));
//        tableView.getColumns().addAll(restaurainintId, FoodCategory, FoodName, FoodPrice);

            // Load data from the menu.txt file and populate the TableView
            ObservableList<food> foodItems = loadFoodItemsFromMenuFile();
            FoodListTable.setEditable(true);
            FoodListTable.setItems( foodItems);
        }


        // Method to read data from the menu.txt file and return a list of FoodItem objects
        private ObservableList<food> loadFoodItemsFromMenuFile() {
            ObservableList<food> foodItems = FXCollections.observableArrayList();
            try{
                List<food> foodList = restaurantObj.getRestaurantMenu();
                foodItems.addAll(foodList);
            }
            catch (Exception e){
                e.printStackTrace();
            }

            return foodItems;
        }


    public void initializeColumns() throws IOException {
//        FoodListTable.setVisible(false);
//        OrderTableView.setVisible(false);
        restaurantManagerObj = new restaurantManager();
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("restaurantName"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("restaurantPriceRange"));
        scoreCol.setCellValueFactory(new PropertyValueFactory<>("restaurantScore"));
        zipCol.setCellValueFactory(new PropertyValueFactory<>("restaurantZipCode"));
        catCol.setCellValueFactory(new PropertyValueFactory<>("restaurantCategory"));
        idRestaurantCol.setCellValueFactory(new PropertyValueFactory<>("restaurantId"));
        foodName.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        foodPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        totalFoodPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        customerName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        Accepted.setCellValueFactory(new PropertyValueFactory<>("button"));



        ObservableList<restaurantExtended> rest = loadRestaurants();
        restaurantTableView.setEditable(true);
        restaurantTableView.setItems( rest);
    }

    public void initializeColumns3(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                ObservableList<OrderExtended> order = loadOrders();
                OrderTableView.setEditable(true);
                OrderTableView.setItems( order);
                OrderTableView.refresh();
            }
        });

    }
    public ObservableList<OrderExtended> loadOrders(){
        ObservableList<OrderExtended> orderItem = FXCollections.observableArrayList();
        List<Order> orderObj = main.orderList;
        for(var order: orderObj ){
            if(order!=null){

                orderItem.add(new OrderExtended(order,main));
            }
        }
        return orderItem;
    }

    private ObservableList<restaurantExtended> loadRestaurants() {
        ObservableList<restaurantExtended> restItem = FXCollections.observableArrayList();
        List<restaurant> restObj = restaurantManagerObj.getRestaurants();
        for(var rest: restObj ){
            if(rest!=null){
                if(rest.getId()==Integer.parseInt(main.getId())) {
                    restaurantObj = rest;
                    restItem.add(new restaurantExtended(rest));
                    break;
                }
            }
        }
        return restItem;
    }


    public void showOrder(ActionEvent actionEvent) {
//        OrderTableView.setVisible(true);
        initializeColumns3();
        System.out.println("order list shown");
    }

    public void setMain(mainRestaurantManager main){
        System.out.println("hi");
        this.main = main;
//        if(this.main==null)
//            System.out.println("null");
//        else
//            System.out.println("not null");
    }

    public void GoingBack(ActionEvent actionEvent) {

        main.showManagerLoginPage();
    }

    public void loggingOut(ActionEvent actionEvent) throws Exception {
        main.showManagerLoginPage();
    }

    public void showingAllFoods(ActionEvent actionEvent) throws IOException {
        if (main != null) {
            FoodListTable.setVisible(true);
            initializeColumns2();
        } else {
            // Handle the case where 'main' is null (e.g., log an error or display a message).
            System.err.println("Error: 'main' is null.");
        }
    }

//    public void foodDelivery(ActionEvent actionEvent) throws IOException {
//        System.out.println("food delivered");
////        for(var bill: main.billList){
////            if(bill!=null){
////                main.getNetworkUtil().write(bill);
////            }
////        }
//    }
}

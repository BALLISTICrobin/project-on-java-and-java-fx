package com.example.restaurantfx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main extends Application {
    private Stage stage;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private SocketWrapper networkUtil;
    public List<Order> OrderList;

    public List<Bill> paySlip;

    public Stage getStage() {
        return stage;
    }
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        OrderList = new ArrayList<>();
        paySlip = new ArrayList<>();
        connectToServer();
        showClientLoginPage();
    }
    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        networkUtil = new SocketWrapper(serverAddress, serverPort);
        new clientCustomerReadThread(this);
    }



    public SocketWrapper getNetworkUtil() {
        return networkUtil;
    }

    public void setNetworkUtil(SocketWrapper networkUtil) {
        this.networkUtil = networkUtil;
    }

    void showClientLoginPage() throws Exception{

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("client.fxml"));
            Parent root = loader.load();

            // Loading the controller
            clientLoginController controller = loader.getController();
            controller.setMain(this);

            // Set the primary stage
            stage.setTitle("Customer Login Page");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }


    }

    void showAlert() {
         Alert alert = new Alert(Alert.AlertType.ERROR);
         alert.setTitle("Error");
         alert.setHeaderText("Invalid Credentials");
         alert.setContentText("Please enter valid credentials!");
         alert.showAndWait();
    }


//    public void showManagerLoginPage() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("restaurantManager.fxml"));
//            Parent root = loader.load();
//
//            // Loading the controller
//            managerLoginController controller = loader.getController();
//            controller.setMain(this);
//
//            // Set the primary stage
//            stage.setTitle("Restaurant Manager Login Page");
//            stage.setScene(new Scene(root, 800, 800));
//            stage.show();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

    public void showAllRestaurantDetails() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("RestaurantDetailsFromClient.fxml"));
            Parent root = loader.load();

            // Loading the controller
            showRestaurantDetailsFromClientController controller = loader.getController();
            controller.load();
            controller.setMain(this);

            // Set the primary stage
            Platform.runLater(() -> {
                stage.setTitle("All Restaurants");
                stage.setScene(new Scene(root, 800, 800));
                stage.show();
            });

        } catch (Exception e) {
            System.out.println("HI");
            System.out.println(e);
        }

    }
    public void showSearchPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Searching.fxml"));
            Parent root = loader.load();

            // Loading the controller
            SearchingController controller = loader.getController();
            controller.setMain(this);

            // Set the primary stage
            stage.setTitle("Search Page");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void showSearchFoodPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("searchFood.fxml"));
            Parent root = loader.load();

            // Loading the controller
            searchFoodController controller = loader.getController();

            controller.setMain(this);

            // Set the primary stage
            stage.setTitle("Search food");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void showSearchFoodByRestaurant() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("searchFoodByRestaurant.fxml"));
            Parent root = loader.load();

            // Loading the controller
            searchFoodByRestaurantController controller = loader.getController();

            controller.setMain(this);

            // Set the primary stage
            stage.setTitle("Search Food For Certain Restaurant");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void showCartPage() {
        try {
//            for(var order: OrderList){
//                System.out.println(order.getFoodName());
//            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("cart.fxml"));
            Parent root = loader.load();

            // Loading the controller
            cartController controller = loader.getController();
            controller.setMain(this);
            controller.load();

            // Set the primary stage
            stage.setTitle("Cart");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showOrderStatusPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("orderStatus.fxml"));
            Parent root = loader.load();

            // Loading the controller
            orderStatusController controller = loader.getController();
            controller.setMain(this);
            controller.load();

            Platform.runLater(() -> {
                // Set the primary stage
                stage.setTitle("Order Status");
                stage.setScene(new Scene(root, 800, 800));
                stage.show();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showOrderStatusPageByRest() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("orderStatusByRest.fxml"));
            Parent root = loader.load();

            // Loading the controller
            orderStatusByRestController controller = loader.getController();
            controller.setMain(this);
            controller.load();

            Platform.runLater(() -> {
                // Set the primary stage
                stage.setTitle("Order Status By Rest");
                stage.setScene(new Scene(root, 800, 800));
                stage.show();
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showCartPageByRest() {
        try {
//            for(var order: OrderList){
//                System.out.println(order.getFoodName());
//            }
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("cartByRest.fxml"));
            Parent root = loader.load();

            // Loading the controller
            cartByRestController controller = loader.getController();
            controller.setMain(this);
            controller.load();

            // Set the primary stage
            stage.setTitle("Cart");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void showRestaurants() {
//        try {
//            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(getClass().getResource("restaurantDetailsFromFoodieMasterpieceManager.fxml"));
//            Parent root = loader.load();
//
//            // Loading the controller
//            showRestaurantDetailsFromManagerViewController controller = loader.getController();
//            controller.load();
//            controller.setMain(this);
//
//            // Set the primary stage
//            stage.setTitle("all restaurants");
//            stage.setScene(new Scene(root, 800, 800));
//            stage.show();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}

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

import static javafx.application.Application.launch;

public class mainRestaurantManager extends Application {
    private Stage stage;
    private String id;
    public List<Order> orderList;
    public List<Bill> billList;

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SocketWrapper getNetworkUtil() {
        return networkUtil;
    }

    public void setNetworkUtil(SocketWrapper networkUtil) {
        this.networkUtil = networkUtil;
    }

    private SocketWrapper networkUtil;
    public Stage getStage() {
        return stage;
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        orderList = new ArrayList<>();
        billList = new ArrayList<>();
        stage = primaryStage;
        connectToServer();
        showManagerLoginPage();
    }

    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        networkUtil = new SocketWrapper(serverAddress, serverPort);
        new clientRestaurantReadThread(this);
    }
    public void showManagerLoginPage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("restaurantManager.fxml"));
            Parent root = loader.load();

            // Loading the controller
            managerLoginController controller = loader.getController();
            controller.setMain(this);

            // Set the primary stage
            stage.setTitle("Restaurant Manager Login Page");
            stage.setScene(new Scene(root, 800, 800));
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void showRestaurants() {
        try {
            System.out.println("HI");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("restaurantDetailsFromFoodieMasterpieceManager.fxml"));
            Parent root = loader.load();

            // Loading the controller
            showRestaurantDetailsFromManagerViewController controller = loader.getController();
            controller.setMain(this);
            controller.load();


            Platform.runLater(() -> {
                // Set the primary stage
                stage.setTitle("Restaurants Info");
                stage.setScene(new Scene(root, 800, 800));
                stage.show();
            });
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



    public void removeOrder(String foodName) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getFoodName().equals(foodName)) {
                orderList.remove(i);
                break;
            }
        }
    }
}

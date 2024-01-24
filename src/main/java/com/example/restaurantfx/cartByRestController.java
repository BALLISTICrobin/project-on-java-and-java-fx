package com.example.restaurantfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;


public class cartByRestController  {
    public Button back;
    public Button logOut;
    public Button orderPlaced;
    private main main;

    @FXML
    private TableView<Order> OrderTableView;

    @FXML
    private TableColumn<Order,Double> TotalPrice;

    @FXML
    private TableColumn<Order,String> foodNameCol;

    @FXML
    private TableColumn<Order,Double> foodPriceCol;

    @FXML
    private TableColumn<Order,Integer> idCol;

    @FXML
    private TableColumn<Order,Double> quantityCol;

    public void initializeColumns() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("restaurantId"));
        foodNameCol.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        foodPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        TotalPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        ObservableList<Order> orders = LoadOrders();
        OrderTableView.setItems(orders);
    }

    public void load(){
        initializeColumns();
    }

    private ObservableList<Order> LoadOrders(){
        ObservableList<Order> orders = FXCollections.observableArrayList();
        List<Order> orderList = main.OrderList;
        for(var order: orderList){
            if(order!=null){
                orders.add(order);
            }
        }
        return orders;

    }
    public void setMain(main main) {
        this.main = main;
    }


    public void goingBack(ActionEvent actionEvent) {
        main.showSearchFoodByRestaurant();
        main.OrderList.clear();
    }

    public void loggingOut(ActionEvent actionEvent) throws Exception {
        main.showClientLoginPage();
        main.OrderList.clear();
    }

    public void placeOrder(ActionEvent actionEvent) throws IOException {
        System.out.println("Order placed");
        List<Order> orderList = main.OrderList;
        for(var order: orderList){
            if(order!=null){
                main.getNetworkUtil().write(order);
            }
        }
//        orderListClass orderListObj = new orderListClass(orderList);
//        for(var order: orderListObj.orderList){
//            if(order!=null){
//                System.out.println(order.getFoodName());
//            }
//        }
//    main.getNetworkUtil().write(orderListObj);
    }
}

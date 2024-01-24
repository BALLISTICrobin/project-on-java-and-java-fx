package com.example.restaurantfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class orderStatusController {
    public Button back;
    public Button logout;
    private main main;

    public TableView<Bill> orderStatusTableView;
    @FXML
    private TableColumn<Bill,String> foodNameCol;

    @FXML
    private TableColumn<Bill,Double> foodPriceCol;



    @FXML
    private TableColumn<Bill, Integer> quantityCol;

    @FXML
    private TableColumn<Bill,Double> totalPriceCol;

    public void initializeColumns(){
        foodNameCol.setCellValueFactory(new PropertyValueFactory<>("foodName"));
        foodPriceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        totalPriceCol.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));

        ObservableList<Bill> AcceptedOrderList = loadOrderStatus();
        orderStatusTableView.setItems(AcceptedOrderList);
        orderStatusTableView.setEditable(true);

    }
    public void load(){
        initializeColumns();
    }

    public ObservableList<Bill> loadOrderStatus(){
        ObservableList<Bill> AcceptedOrderList = FXCollections.observableArrayList();
        for(Bill bill:main.paySlip){
            if(bill!=null){
                AcceptedOrderList.add(bill);
            }
        }
        return AcceptedOrderList;
    }

    public void setMain(main main) {
        this.main = main;
    }

    public void goingBack(ActionEvent actionEvent) {
        main.showSearchFoodPage();
    }


    public void loggingOut(ActionEvent actionEvent) throws Exception {
        main.showClientLoginPage();
    }
}

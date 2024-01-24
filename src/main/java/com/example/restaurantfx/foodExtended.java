package com.example.restaurantfx;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.util.List;

public class foodExtended {

    private int restaurantId;
    private String foodCategory="";
    private String foodName ="";
    private double foodPrice;

   private main main;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public Spinner<Integer> getNumberSpinner() {
        return numberSpinner;
    }

    public void setNumberSpinner(Spinner<Integer> numberSpinner) {
        this.numberSpinner = numberSpinner;
    }

    public Button getAddToCart() {
        return addToCart;
    }

    public void setAddToCart(Button addToCart) {
        this.addToCart = addToCart;
    }

    public Button getRemoveOrder() {
        return removeOrder;
    }

    public void setRemoveOrder(Button removeOrder) {
        this.removeOrder = removeOrder;
    }

    private Spinner<Integer> numberSpinner;
    private Button addToCart;
    private Button removeOrder;
    private Order orderObj;

    foodExtended(food obj,main main){
        this.foodName = obj.getFoodName();
        this.restaurantId = obj.getRestaurantId();
        this.foodCategory = obj.getFoodCategory();
        this.foodPrice = obj.getFoodPrice();
        this.addToCart = new Button("Add to cart");
        this.removeOrder = new Button("Remove");
        this.removeOrder.setVisible(false);
        this.numberSpinner = new Spinner<>();
        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,20,1);
        this.numberSpinner.setValueFactory(svf);
        this.main = main;
        addToCart.setOnAction(this::addingToCart);
        removeOrder.setOnAction(this::removingFromCart);

    }
    public void setMain(main main) {
        this.main = main;
    }

    private void addingToCart(ActionEvent actionEvent) {
        this.removeOrder.setVisible(true);
        this.removeOrder.setDisable(false);
        orderObj = new Order(restaurantId,foodName,numberSpinner.getValue(),foodPrice);
        orderObj.setUsername(main.getUserName());
        main.OrderList.add(orderObj);
        this.addToCart.setDisable(true);
        this.addToCart.setVisible(false);
    }
    private void removingFromCart(ActionEvent actionEvent) {
        main.OrderList.remove(orderObj);
        this.removeOrder.setVisible(false);
        this.removeOrder.setDisable(true);
        this.addToCart.setVisible(true);
        this.addToCart.setDisable(false);
    }


}

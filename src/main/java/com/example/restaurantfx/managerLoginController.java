package com.example.restaurantfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class managerLoginController {
    private mainRestaurantManager main;
    public Button logOut;
    public TextField restaurantName;

    @FXML
    private Button Back;

    @FXML
    private Button Reset;



    @FXML
    private TextField restaurantId;

    @FXML
    private Button submit;

//    @FXML
//    void goBack(ActionEvent event) throws Exception {
//        main.showLoginPage();
//
//    }

    @FXML
    void resetText(ActionEvent event) {
        restaurantName.setText(null);
        restaurantId.setText(null);


    }

    @FXML
    void showRestaurantDetails(ActionEvent event) throws IOException {
        String userName = restaurantName.getText();

        String id = restaurantId.getText();

        LoginDTR loginDTR = new LoginDTR();
        loginDTR.setUserName(userName);
        loginDTR.setId(id);
        main.getNetworkUtil().write(loginDTR);
    }
    void setMain(mainRestaurantManager main) {
        this.main = main;
    }

    public void showRestaurantDetail(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.ENTER){
//            String userName = restaurantId.getText();
//            try{
//                int id = Integer.parseInt(userName);
//            }
//            catch (NumberFormatException e){
//                main.showAlert();
//            }
//            String password = managerPass.getText();
//            if (password.equals("1234") ) {
//                try {
//                    main.showRestaurants();
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//            } else {
//                main.showAlert();
//            }
        }
    }

//    public void loggingOut(ActionEvent actionEvent) throws Exception {
//        main.showLoginPage();
//    }
    public void setmain(mainRestaurantManager main){
        this.main = main;
    }
}

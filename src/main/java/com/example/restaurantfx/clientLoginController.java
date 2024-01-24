package com.example.restaurantfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;
import java.io.PrintWriter;


public class clientLoginController {
    private main main;
    @FXML
    private PasswordField userPass;

    @FXML
    private Button reset;

    @FXML
    private Button submit;

    @FXML
    private TextField userText;

    @FXML
    void resetField(ActionEvent event) {
        userText.setText(null);
        userPass.setText(null);

    }

    @FXML
    void showAllRestaurants(ActionEvent event) throws IOException, InterruptedException {
        String userName = userText.getText();
        String password = userPass.getText();
//        if (userName.equals("admin") && password.equals("123")) {
//            try {
//                BufferedWriter writer = new BufferedWriter(new FileWriter("userLog.txt"));
//                PrintWriter pw = new PrintWriter(writer);
//                pw.print(userName+","+password);
//                pw.println("");
//                main.showAllRestaurantDetails();
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        } else {
//            main.showAlert();
//        }
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(userName);
        loginDTO.setPassword(password);

        try {
            main.getNetworkUtil().write(loginDTO);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void showAllRestaurant(KeyEvent keyEvent) {
        if(keyEvent.getCode()== KeyCode.ENTER){
//            String userName = userText.getText();
//            String password = userPass.getText();
//            if (userName.equals("admin") && password.equals("123")) {
//                try {
//                    main.showAllRestaurantDetails();
//                } catch (Exception e) {
//                    System.out.println(e);
//                }
//            } else {
//                main.showAlert();
//            }
        }
    }
    void setMain(main main) {
        this.main = main;
    }


//    public void goBack(ActionEvent actionEvent) throws Exception {
//        main.showLoginPage();
//    }
}

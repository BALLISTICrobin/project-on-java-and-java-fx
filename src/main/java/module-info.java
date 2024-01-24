module com.example.restaurantfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.restaurantfx to javafx.fxml;
    exports com.example.restaurantfx;
}
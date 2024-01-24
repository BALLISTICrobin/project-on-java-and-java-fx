package com.example.restaurantfx;

import java.io.Serializable;

public class LoginDTR implements Serializable {

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getId() {
        return id;
    }

    public void setId(String password) {
        this.id = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    private String userName;
    private String id;
    private boolean status;
}

package com.restapi.restapiexample.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user_info")
public class User {

    @Id
    private String userId;
    private String UserName;
    private String UserAddress;
    private String UserPhone;

    public User(String userId, String userName, String userAddress, String userPhone) {
        this.userId = userId;
        UserName = userName;
        UserAddress = userAddress;
        UserPhone = userPhone;
    }

    public User() {
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setUserAddress(String userAddress) {
        UserAddress = userAddress;
    }

    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }


    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public String getUserPhone() {
        return UserPhone;
    }

}

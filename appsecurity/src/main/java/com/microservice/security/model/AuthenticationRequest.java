package com.microservice.security.model;


public class AuthenticationRequest {

    private String userName;

    public AuthenticationRequest(){

    }

    public AuthenticationRequest(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

}

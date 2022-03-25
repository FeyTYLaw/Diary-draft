package com.example.Diary_app_draft;

public class User {
    String username;
    String password;
    String confirmPassword;
    String email;

    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.email = "";
    }
}

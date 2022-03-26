package com.example.Diary_app_draft;

import android.content.Context;
import android.content.SharedPreferences;

public class UserDatabase {
    public static final String SP_NAME = "userDetail";
    SharedPreferences userDatabase;

    public UserDatabase(Context context){
        userDatabase = context.getSharedPreferences(SP_NAME, 0);

    }
    public void storeUserData(User user){
        SharedPreferences.Editor spEditor = userDatabase.edit();
        spEditor.putString("name", user.username);
        spEditor.putString("email", user.email);
        spEditor.putString("password", user.password);
        spEditor.apply();
    }
    public User getLoggedInUser(){
        String username = userDatabase.getString("name","");
        String password = userDatabase.getString("password","");
        String email = userDatabase.getString("email","");

        User storedUser = new User(username, email, password );

        return storedUser;
    }
    public void setUserLoggedIn(boolean loggedIn){
        SharedPreferences.Editor spEditor = userDatabase.edit();
        spEditor.putBoolean("loggedin",loggedIn);
        spEditor.apply();
    }

    public boolean getUserLoggedIn(){
        return userDatabase.getBoolean("loggedIn", false);
        }

    public void clearUserData(){
        SharedPreferences.Editor spEditor = userDatabase.edit();
        spEditor.clear();
        spEditor.apply();
    }
}

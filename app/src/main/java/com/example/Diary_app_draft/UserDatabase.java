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
    }
}

package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.PrivateKey;

public class NewentryActivity extends AppCompatActivity implements View.OnClickListener{

    Button logout;
    EditText username;
    UserDatabase userDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newentry);
        logout = findViewById(R.id.Logout);
        username = findViewById(R.id.username);
        logout.setOnClickListener(this);
    }
    /*@Override
    protected void onStart(){
        super.onStart();
        if (authenticate()==true){
            displayUserInfo();
        }
    }
    private boolean authenticate(){
        return userDatabase.getUserLoggedIn();
    }

    private void displayUserInfo(){
        User user = userDatabase.getLoggedInUser();
        username.setText(user.username);
    }*/
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Signin.class);
        startActivity(intent);
        switch(view.getId()){
            case R.id.Logout:
                userDatabase.clearUserData();
                userDatabase.setUserLoggedIn(false);

                break;
        }
    }
}
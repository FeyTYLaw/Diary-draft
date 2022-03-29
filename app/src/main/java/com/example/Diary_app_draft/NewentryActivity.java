package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class NewentryActivity extends AppCompatActivity implements View.OnClickListener{

    Button logout;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newentry);
        logout = findViewById(R.id.Logout);
        username = findViewById(R.id.username);
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, Signin.class);
        startActivity(intent);

    }
}
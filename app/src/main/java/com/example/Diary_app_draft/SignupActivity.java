package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class SignupActivity extends AppCompatActivity {
    public Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        button = (Button) findViewById(R.id.signupbutton);


        EditText username = (EditText) findViewById(R.id.username);
        MaterialButton registerButton = (MaterialButton) findViewById(R.id.signupbutton);

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SignupActivity.this,Signin.class);
                startActivity(intent);
                String username1 = username.getText().toString();
                Toast.makeText(SignupActivity.this,"Username is" + username1,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
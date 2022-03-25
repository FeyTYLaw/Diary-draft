package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.util.Patterns;
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
    EditText username;
    EditText email;
    EditText password;
    EditText confirmPassword;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        email = findViewById(R.id.email);
        register = findViewById(R.id.signupbutton);

        //button = (Button) findViewById(R.id.signupbutton);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chekDataEntered();
            }
        });
    }

    public boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    public boolean isEmail(EditText text){
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    void chekDataEntered() {
        if(isEmpty(username)){
            Toast t = Toast.makeText(this,"Username is required!", Toast.LENGTH_SHORT);
            t.show();
        }
        if (isEmail(email) == false){
            email.setError("Enter Valid email!");
        }
    }


  /*      EditText username = (EditText) findViewById(R.id.username);
        MaterialButton registerButton = (MaterialButton) findViewById(R.id.signupbutton);

        registerButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(SignupActivity.this,Signin.class);
                startActivity(intent);
                String username1 = username.getText().toString();
                Toast.makeText(SignupActivity.this,"Username is" + username1,Toast.LENGTH_SHORT).show();
            }*/
    //});

}
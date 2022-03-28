package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Signin extends AppCompatActivity {


    private EditText username;
    private EditText password;
    private Button login;
    private Button register;

    private String Username = "Admin";
    private String Password = "12345";
    boolean isValid = false;
    UserDatabase  userDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.siginpbutton);
        register = findViewById(R.id.noaccount);
        userDatabase = new UserDatabase(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.siginpbutton:
                       // User user = new User(null, null);
                       // userDatabase.storeUserData(user);
                        userDatabase.setUserLoggedIn(true);
                        break;
                }
                Intent intent = new Intent(Signin.this, SignupActivity.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = username.getText().toString();
                String inputPassword = password.getText().toString();

                if(inputName.isEmpty()|| inputPassword.isEmpty()){
                    Toast.makeText(Signin.this,"Please enter email or Password", Toast.LENGTH_SHORT).show();
                }else{
                    isValid = validate(inputName, inputPassword);
                    if(!isValid){
                        Toast.makeText(Signin.this,"Your username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Signin.this,"Login Successful", Toast.LENGTH_SHORT).show();
                        //Add the code to go to new activity
                        Intent intent = new Intent(Signin.this, NewentryActivity.class);
                        startActivity(intent);

                    }
                }
            }
        });
    }
    private boolean validate(String name, String password){
        return name.equals(Username) && password.equals(Password);
    }


}

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

import java.util.ArrayList;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    //public Button button;
    EditText username;
    EditText email;
    EditText password;
    EditText confirmPassword;
    Button register;
    ArrayList<String> userLoginInfo = new ArrayList<String>();


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
        if (!isEmail(email)){
            email.setError("Enter Valid email!");
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.signupbutton:
                String name = username.getText().toString();
                String password = this.password.getText().toString();
                String email = this.email.getText().toString();
                //User registeredData = new User(name,email, password);
                break;
        }
    }

/*

    EditText  = (EditText) findViewById(R.id.edittext);
    String text = ed.getText().toString();
    int arr[] = new int[text.length()/2];//Assuming no spaces and user is using one comma between numbers
    int i=0;
    while(text!=null && text.length()>0) {
        arr[i] = Integer.parseInt(text.substring(0,1));
        text = text.substring(text.indexOf(",")+1);
        i++;
    }
*/


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
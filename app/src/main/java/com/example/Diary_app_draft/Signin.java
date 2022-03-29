package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Signin extends AppCompatActivity {


    private EditText username;
    private EditText password;
    private Button login;
    private Button register;
    private Button noAcc;

    /*private String Username = "Admin";
    private String Password = "12345";
    boolean isValid = false;*/

    SQLHelper SQL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.siginpbutton);
        register = findViewById(R.id.signupbutton);
        noAcc = findViewById(R.id.noaccount);

        SQL = new SQLHelper(this);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pw = password.getText().toString();

                if (user.equals("") || pw.equals("")) {
                    Toast.makeText(Signin.this, "Please fill up all the fields", Toast.LENGTH_SHORT).show();
                } else {
                    Boolean checkuserpass = SQL.checkusernamepassword(user, pw);
                    if (checkuserpass) {
                        Toast.makeText(Signin.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), NewentryActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Signin.this, "Your username or password is incorrect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        noAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signin.this, SignupActivity.class);
                startActivity(intent);

            }
        });

    }

}

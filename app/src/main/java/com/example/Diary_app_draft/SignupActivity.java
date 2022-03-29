package com.example.Diary_app_draft;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText confirmPassword;
    Button register;
    Button signin;
    SQLHelper SQL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        register = findViewById(R.id.signupbutton);
        signin =findViewById(R.id.siginpbutton);
        SQL = new SQLHelper(this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pw = password.getText().toString();
                String rePw = confirmPassword.getText().toString();

                if(user.equals("")|| pw.equals("")||rePw.equals("")){
                    Toast.makeText(SignupActivity.this, "Please fill up all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(pw.equals(rePw)){
                        Boolean checkuser = SQL.checkusername(user);
                        if(!checkuser){
                            Boolean insert =SQL.insertData(user, pw);
                            if(insert) {
                                Toast.makeText(SignupActivity.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Signin.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignupActivity.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignupActivity.this, "User already registered! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignupActivity.this, "Incorrect Password!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Signin.class);
                startActivity(intent);
            }
        });
    }
    }


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
    private TextView attemtsInfo;
    private String Username = "Admin";
    private String Password = "12345";
    boolean isValid = false;


   /* SignInButton signInButton;
    GoogleSignInClient mGoogleSignInClient;
    static final int RC_SIGN_IN = 0;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        //email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.enterpassword);
        login = findViewById(R.id.siginpbutton);
        register = findViewById(R.id.noaccount);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        if(name.equals(Username) && password.equals(Password)){
            return true;
        }
        return false;
    }
}
 /*   public void toSignup(View v) {
        startActivity(new Intent(Signin.this, SignupActivity.class));

    }
    public void onClick(View view) {
        Intent i = new Intent(Signin.this, SignupActivity.class);
        startActivity(i);}

}*/
/*

        setupUI();
        setupListeners();

       */
/* signInButton = (SignInButton) findViewById(R.id.googlesignin);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.googlesignin:
                        signIn();
                        break;
                }

            }
        });
*//*

    }

    */
/*private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }*//*


   */
/* @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }*//*


   */
/* private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            Toast.makeText(this, "Sign-in Successful", Toast.LENGTH_SHORT).show();
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("Error", "signInResult:failed code=" + e.getStatusCode());

        }
    }*//*

*/
/*
    public void toSignup(View v) {
        startActivity(new Intent(Signin.this, SignupActivity.class));

    }*//*


    private void setupUI() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.noccount);
        login = findViewById(R.id.signupbutton);
    }

    private void setupListeners() {
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUsername();
            }

        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signin.this, SignupActivity.class);
                startActivity(i);

            }
        });

    }

    void checkUsername() {
        boolean isValid = true;
        if (isEmpty(username)) {
            username.setError("Enter username to login");
            isValid = false;
        } else {
            if (!isEmail(username)) {
                username.setError("Enter vialid email");
                isValid = false;
            }
        }
        if (isEmpty(password)) {
            password.setError("Enter password to login");
            isValid = false;
        } else {
            if (password.getText().toString().length() < 5) {
                password.setError("Password must be at least 4 chars characters long ");
                isValid = false;
            }
        }

        if (isValid) {
            String usernameValue = username.getText().toString();
            String passwordVlaue = password.getText().toString();

            if (usernameValue.equals("test@test.com") && passwordVlaue.equals("password1234")) {
                //everything checked we open new activity
                Intent i = new Intent(Signin.this, WelcomePageSlideActivity.class);
                startActivity(i);
                //we close this activity
                this.finish();
            } else {
                Toast t = Toast.makeText(this, "Wrong email or password!", Toast.LENGTH_SHORT);
                t.show();
            }

        }
    }

    boolean isEmail(EditText text) {
        CharSequence email = text.getText().toString();
        return (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }
    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}*/

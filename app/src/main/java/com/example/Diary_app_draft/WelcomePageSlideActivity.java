package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;



public class WelcomePageSlideActivity extends AppCompatActivity {
    private static int FADING = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page_slide);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(WelcomePageSlideActivity.this, Signin.class);
                startActivity(intent);
                finish();
            }
        }, FADING);
    }
}
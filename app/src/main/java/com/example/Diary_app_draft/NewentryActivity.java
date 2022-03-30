package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class NewentryActivity extends AppCompatActivity {

    private EditText Entry;
    private TextView Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newentry);

        Entry = findViewById(R.id.Entry);

    }
}
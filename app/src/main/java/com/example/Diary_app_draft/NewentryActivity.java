package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class NewentryActivity extends AppCompatActivity implements View.OnClickListener {

    Button logout;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newentry);
        logout = findViewById(R.id.layout);
        username = findViewById(R.id.username);
        logout.setOnClickListener(this);

        //Adding current date
        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());

        TextView textviewDate = findViewById(R.id.Date);
        textviewDate.setText(currentDate);
        String cal = calender.toString();

    }
    @Override
    public void onClick(View view){
        Intent intent = new Intent(this, Signin.class);
        startActivity(intent);
    }
}
package com.example.Diary_app_draft.Sharepreference;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.Diary_app_draft.Login_reg.Signin;
import com.example.Diary_app_draft.Login_reg.SignupActivity;
import com.example.Diary_app_draft.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class entryplusview extends AppCompatActivity {
    private Button save;
    private Button Logout;
    private EditText diaryEntry;
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private Button remove;
    private List<TaskModel> taskList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entryplusview);

        Logout = findViewById(R.id.nLogOut);
        save = findViewById(R.id.Save);
        recyclerView = findViewById(R.id.recyclerview);
        diaryEntry = findViewById(R.id.et_entry);
        remove = findViewById(R.id.remove);

        taskList = perfCon.readListFromPref(this);

        if (taskList == null)
            taskList = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new TaskAdapter(getApplicationContext(), taskList);
        recyclerView.setAdapter(adapter);



         Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(entryplusview.this, Signin.class);
                startActivity(intent);

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TaskModel taskModel = new TaskModel(diaryEntry.getText().toString(), getDate());
                taskList.add(taskModel);
                perfCon.writeListInPref(getApplicationContext(), taskList);
                Collections.reverse(taskList);
                adapter.setTaskModelList(taskList);

                if (!diaryEntry.getText().equals(""))
                    diaryEntry.setText("");

            }
        });



    }

    private String getDate() {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.valueOf(dateFormat.format(date));

    }





}

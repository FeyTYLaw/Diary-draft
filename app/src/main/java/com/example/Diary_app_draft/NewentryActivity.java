package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class NewentryActivity extends AppCompatActivity implements View.OnClickListener {

    

    Button logout;
    EditText username;
    private EditText TitleEntry;
    private TextView Date;
    private EditText inputDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newentry);
        logout = findViewById(R.id.Logout);
        username = findViewById(R.id.username);
        logout.setOnClickListener(this);

        //Adding current date
        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());

        TextView textviewDate = findViewById(R.id.Date);
        textviewDate.setText(currentDate);
        String cal = calender.toString();
        TitleEntry = findViewById(R.id.TitleEntry);
        inputDiary = findViewById(R.id.inputDiary);

    }
    @Override
    public void onClick(View view){
        Intent intent = new Intent(this, Signin.class);
        startActivity(intent);
    }
    private void saveDiary(){
        if (TitleEntry.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Note title should be added!", Toast.LENGTH_SHORT).show();
            return;
        }

        final DiaryEntry noteDiary = new DiaryEntry();
        noteDiary.setMainTitle(TitleEntry.getText().toString());
        noteDiary.setDiaryText(inputDiary.getText().toString());

        @SuppressLint("StaticFieldLeak")
        class SaveDiaryTask extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids){
                DiaryDataBase.getDataBase(getApplicationContext()).diaryDao().insertDiary(noteDiary);
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid){
                super.onPostExecute(aVoid);
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        }

        new SaveDiaryTask().execute();

    }

}
package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

public class FolderActivity extends AppCompatActivity {
    private ImageView addEntry;
    private Button addNewEntry;

    public static final int REQUEST_CODE_ADD_ENTRY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.folder);

        addNewEntry = findViewById(R.id.addEntry);
        addNewEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FolderActivity.this, NewentryActivity.class);
                startActivity(intent);
            }
        });


        getDiaryText();
    }

    private void getDiaryText(){

        @SuppressLint("StaticFieldLeak")
        class GetDiaryTask extends AsyncTask<Void, Void, List<DiaryEntry>> {
            @Override
            protected List<DiaryEntry> doInBackground(Void... voids) {
                return DiaryDataBase
                        .getDiaryDataBase(getApplicationContext())
                        .diaryDao().getDiaryInput();
            }

            @Override
            protected void onPostExecute(List<DiaryEntry> diaryEntries) {
                super.onPostExecute(diaryEntries);
                Log.d("Diary", diaryEntries.toString());

            }
        }

        new GetDiaryTask().execute();

    }

}
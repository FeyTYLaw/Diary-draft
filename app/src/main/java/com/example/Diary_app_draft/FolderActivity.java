package com.example.Diary_app_draft;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class FolderActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.folder);


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
                Log.d("My Diary", diaryEntries.toString());

            }
        }

        new GetDiaryTask().execute();

    }

}
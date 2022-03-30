package com.example.Diary_app_draft;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = DiaryEntry.class, version = 1, exportSchema = false)
public abstract class DiaryDataBase extends RoomDatabase {

    private static DiaryDataBase diaryDataBase;

    public static synchronized DiaryDataBase getDiaryDataBase(Context context){
        if(diaryDataBase == null){
            diaryDataBase = Room.databaseBuilder(
                    context,
                    DiaryDataBase.class,
                    "diary_db"
            ).build();
        }
        return diaryDataBase;
    }

    public abstract DiaryDao diaryDao();


}

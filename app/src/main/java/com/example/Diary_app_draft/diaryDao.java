package com.example.Diary_app_draft;

import android.app.Dialog;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface diaryDao {
    @Query("SELECT* FROM Diary ORDER BY id DESC")
    List<DiaryEntry> getDiaryInput();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDiary(DiaryEntry diaryEntry);

    @Delete
    void deleteDiaryEntry(DiaryEntry diaryEntry);

}

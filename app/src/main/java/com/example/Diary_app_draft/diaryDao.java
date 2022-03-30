package com.example.Diary_app_draft;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface diaryDao {
    @Query("SELECT* FROM Diary ORER BY id DESC")
    List<DiaryEntry> getDiaryText();


}

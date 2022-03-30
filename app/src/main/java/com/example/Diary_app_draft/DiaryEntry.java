package com.example.Diary_app_draft;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class DiaryEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "main_title")
    private String mainTitle;

    @ColumnInfo (name = "date")
    private String date;

    @ColumnInfo (name = "diary_text")
    private String diaryText;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public void setMainTitle(String mainTitle) {
        this.mainTitle = mainTitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDiaryText() {
        return diaryText;
    }

    public void setDiaryText(String diaryText) {
        this.diaryText = diaryTextb;
    }

    @Override
    public String toString() {
        return "DiaryEntry{" +
                "id=" + id +
                ", mainTitle='" + mainTitle + '\'' +
                ", date='" + date + '\'' +
                ", diaryText='" + diaryText + '\'' +
                '}';
        }
    }



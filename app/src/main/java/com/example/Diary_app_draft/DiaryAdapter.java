package com.example.Diary_app_draft;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.DiaryViewHodler> {

    private List<DiaryEntry> Diary;

    public DiaryAdapter(List<DiaryEntry> Diary) {
        this.Diary = Diary;
    }

    @NonNull
    @Override
    public DiaryViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DiaryViewHodler(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.newentry,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryViewHodler holder, int position) {
        holder.setDiaryText(Diary.get(position));
    }

    @Override
    public int getItemCount() {
        return Diary.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    static class DiaryViewHodler extends RecyclerView.ViewHolder {

        TextView mainTitle, date;

        DiaryViewHodler(@NonNull View itemView) {
            super(itemView);
            mainTitle = itemView.findViewById(R.id.TitleEntry);
            date = itemView.findViewById(R.id.Date);

        }

        void setDiaryText(DiaryEntry diary) {
            mainTitle.setText(diary.getMainTitle());
            date.setText(diary.getDate());

        }

    }

}

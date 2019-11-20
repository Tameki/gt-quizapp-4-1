package com.geektech.quizapp_4_1.presentation.quiz.recycler;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp_4_1.model.Question;

public class QuizViewHolder extends RecyclerView.ViewHolder {

    private Listener mListener;

    QuizViewHolder(@NonNull View itemView, Listener listener) {
        super(itemView);
        mListener = listener;

        //TODO: Initialize views
    }

    void onBind(Question question) {
        //TODO: Bind question data
    }

    public interface Listener {
        void onAnswerClick(int questionPosition, int answerPosition);
    }
}

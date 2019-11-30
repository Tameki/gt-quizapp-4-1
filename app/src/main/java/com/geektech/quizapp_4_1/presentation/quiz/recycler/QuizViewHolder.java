package com.geektech.quizapp_4_1.presentation.quiz.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.quizapp_4_1.model.EType;
import com.geektech.quizapp_4_1.model.Question;
import com.geektech.quizapp_4_1.util.BaseUtil;

public class QuizViewHolder extends RecyclerView.ViewHolder {

    private Listener mListener;

    private TextView mQuestionTxt;

    private View mBooleanAnswersContainer;
    private TextView mBooleanTrueBtn;
    private TextView mBooleanFalseBtn;

    private View mMultipleAnswersContainer;
    private TextView mMultiple1;
    private TextView mMultiple2;
    private TextView mMultiple3;
    private TextView mMultiple4;

    QuizViewHolder(@NonNull View itemView, Listener listener) {
        super(itemView);
        mListener = listener;

        mBooleanTrueBtn.setOnClickListener(v -> {
            mListener.onAnswerClick(getAdapterPosition(), 0);
        });

        mBooleanFalseBtn.setOnClickListener(v -> {
            mListener.onAnswerClick(getAdapterPosition(), 1);
        });
        //TODO: Initialize views
    }

    void onBind(Question question) {
        mQuestionTxt.setText(BaseUtil.fromHtml(question.getQuestion()));

        if (question.getType() == EType.BOOLEAN) {
            mBooleanAnswersContainer.setVisibility(View.VISIBLE);
            mMultipleAnswersContainer.setVisibility(View.GONE);

            //TODO: mBooleanTrueBtn, mBooleanFalseBtn set label
        } else {
            mBooleanAnswersContainer.setVisibility(View.GONE);
            mMultipleAnswersContainer.setVisibility(View.VISIBLE);

//            mMultiple1.setText();
        }

        //TODO: Bind question data
    }

    public interface Listener {
        void onAnswerClick(int questionPosition, int answerPosition);
    }
}

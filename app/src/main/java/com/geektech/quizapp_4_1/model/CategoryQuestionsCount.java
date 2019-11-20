package com.geektech.quizapp_4_1.model;

import com.google.gson.annotations.SerializedName;

public class CategoryQuestionsCount {

    @SerializedName("total_num_of_questions")
    private Integer totalQuestions;

    @SerializedName("total_num_of_pending_questions")
    private Integer pendingQuestions;

    @SerializedName("total_num_of_verified_questions")
    private Integer verifiedQuestions;

    @SerializedName("total_num_of_rejected_questions")
    private Integer rejectedQuestions;

    public CategoryQuestionsCount(Integer totalQuestions, Integer pendingQuestions, Integer verifiedQuestions, Integer rejectedQuestions) {
        this.totalQuestions = totalQuestions;
        this.pendingQuestions = pendingQuestions;
        this.verifiedQuestions = verifiedQuestions;
        this.rejectedQuestions = rejectedQuestions;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Integer getPendingQuestions() {
        return pendingQuestions;
    }

    public void setPendingQuestions(Integer pendingQuestions) {
        this.pendingQuestions = pendingQuestions;
    }

    public Integer getVerifiedQuestions() {
        return verifiedQuestions;
    }

    public void setVerifiedQuestions(Integer verifiedQuestions) {
        this.verifiedQuestions = verifiedQuestions;
    }

    public Integer getRejectedQuestions() {
        return rejectedQuestions;
    }

    public void setRejectedQuestions(Integer rejectedQuestions) {
        this.rejectedQuestions = rejectedQuestions;
    }
}

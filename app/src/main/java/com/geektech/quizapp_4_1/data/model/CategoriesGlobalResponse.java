package com.geektech.quizapp_4_1.data.model;

import com.geektech.quizapp_4_1.model.CategoryQuestionsCount;

import java.util.Map;

public class CategoriesGlobalResponse {
    private CategoryQuestionsCount overall;

    private Map<String, CategoryQuestionsCount> categories;

    public CategoriesGlobalResponse(CategoryQuestionsCount overall, Map<String, CategoryQuestionsCount> categories) {
        this.overall = overall;
        this.categories = categories;
    }

    public CategoryQuestionsCount getOverall() {
        return overall;
    }

    public void setOverall(CategoryQuestionsCount overall) {
        this.overall = overall;
    }

    public Map<String, CategoryQuestionsCount> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, CategoryQuestionsCount> categories) {
        this.categories = categories;
    }
}

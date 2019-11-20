package com.geektech.quizapp_4_1.data.model;

import com.geektech.quizapp_4_1.model.Category;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriesResponse {
    @SerializedName("trivia_categories")
    List<Category> categories;
}

package com.geektech.quizapp_4_1.data;

import android.util.Log;

import com.geektech.quizapp_4_1.data.model.CategoriesGlobalResponse;
import com.geektech.quizapp_4_1.data.model.QuestionsResponse;
import com.geektech.quizapp_4_1.model.Question;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class QuizRepository implements IQuizRepository {

    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opentdb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private TriviaNetworkClient client =
            retrofit.create(TriviaNetworkClient.class);

    private Question shuffleAnswers(Question question) {
        ArrayList<String> answers = new ArrayList<>();

        answers.add(question.getCorrectAnswer());
        answers.addAll(question.getIncorrectAnswers());

        Collections.shuffle(answers);
        question.setAnswers(answers);

        return question;
    }

    @Override
    public void getQuiz(OnQuizCallback callback) {
        Call<QuestionsResponse> call = client.getQuestions(
                10,
                null,
                null
        );

        Log.d("ololo", call.request().url().toString());

        call.enqueue(new Callback<QuestionsResponse>() {
            @Override
            public void onResponse(Call<QuestionsResponse> call, Response<QuestionsResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        for (int i = 0; i < response.body().getResults().size(); i++) {
                            Question question = response.body().getResults().get(i);
                            response.body().getResults().set(i, shuffleAnswers(question));
                        }

                        callback.onSuccess(response.body().getResults());
                    } else {
                        callback.onFailure(new Exception("Remote data source not initialized"));
                    }
                } else {
                    callback.onFailure(new Exception("Request failed: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<QuestionsResponse> call, Throwable t) {
                callback.onFailure(new Exception(t));
            }
        });
    }



    private interface TriviaNetworkClient {
        @GET("/api.php")
        Call<QuestionsResponse> getQuestions(
                @Query("amount") int amount,
                @Query("category") Integer category,
                @Query("difficulty") String difficulty
        );

        @GET("/api_count_global.php")
        Call<CategoriesGlobalResponse> getCategoriesGlobal();
    }

}

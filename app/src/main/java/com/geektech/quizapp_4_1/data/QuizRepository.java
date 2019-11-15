package com.geektech.quizapp_4_1.data;

import android.util.Log;

import com.geektech.quizapp_4_1.data.model.QuestionsResponse;

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

//    https://opentdb.com/api.php?amount=10 & category=9 & difficulty=easy

//    https://opentdb.com - BASE URL
//    api.php - QUESTIONS API FUNCTION ENDPOINT
//    amount=10 & category=9 & difficulty=easy - QUERY

    private interface TriviaNetworkClient {
        @GET("/api.php")
        Call<QuestionsResponse> getQuestions(
                @Query("amount") int amount,
                @Query("category") Integer category,
                @Query("difficulty") String difficulty
        );
    }

}

package com.example.mynews.networking;

import com.example.mynews.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsAPI {
    @GET("top-headlines")
    Call<NewsResponse> getNewsList(@Query("country") String newCountry, @Query("apiKey") String apiKey);

    @GET("everything")
    Call<NewsResponse> getNewsEverythingFilter(@Query("q") String katakunci, @Query("apiKey") String apiKey);

    @GET("everything")
    Call<NewsResponse> getNewsEverything(@Query("apiKey") String apiKey);

}

package com.example.mynews;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mynews.model.NewsResponse;
import com.example.mynews.networking.NewsRepository;

public class NewsViewModel extends ViewModel {
    private MutableLiveData<NewsResponse> mutableLiveData;
    private NewsRepository newsRepository;

    public void topHeadline(String country){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNews(country, "3b35b7950af94d8da344750275f9f4c8");

    }
    public void getNewsEverythingFilter(String keyword){
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNewsEverythingFilter(keyword, "3b35b7950af94d8da344750275f9f4c8");

    }

    public LiveData<NewsResponse> getNewsRepository() {
        return mutableLiveData;
    }
}

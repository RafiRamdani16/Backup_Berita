package com.example.mynews;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mynews.model.NewsResponse;
import com.example.mynews.networking.NewsRepository;

public class NewsViewModel extends ViewModel {
    private MutableLiveData<NewsResponse> mutableLiveData;
    private NewsRepository newsRepository;

    public void init(){
        if (mutableLiveData != null){
            return;
        }
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNews("id", "86d643f034574ae8a6ebc30c60b606db");

    }
    public void getNewsEverythingFilter(String keyword){
        newsRepository = NewsRepository.getInstance();
        mutableLiveData = newsRepository.getNewsEverythingFilter(keyword, "86d643f034574ae8a6ebc30c60b606db");

    }

    public void eNews(){
        newsRepository = NewsRepository.getInstance();
       mutableLiveData = newsRepository.getEverythingtNews("86d643f034574ae8a6ebc30c60b606db");
    }

    public LiveData<NewsResponse> getNewsRepository() {
        return mutableLiveData;
    }
}

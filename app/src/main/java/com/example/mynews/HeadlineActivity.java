package com.example.mynews;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.adapter.NewsAdapter;
import com.example.mynews.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

public class HeadlineActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<NewsArticle> articleArrayList = new ArrayList<>();
    List<NewsArticle> newsArticles;
    NewsAdapter newsAdapter;
    RecyclerView rvHeadline;
    NewsViewModel newsViewModel;
    String code_country = "id";

    ActionBar back;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.headline_news);
        rvHeadline = findViewById(R.id.rvHeadlineNews);
        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);

        back = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        code_country = getIntent().getStringExtra("country");

        setNews(code_country);

        newsAdapter = new NewsAdapter(HeadlineActivity.this, articleArrayList);
        rvHeadline.setLayoutManager(new LinearLayoutManager(this));
        rvHeadline.setAdapter(newsAdapter);
        rvHeadline.setItemAnimator(new DefaultItemAnimator());
        rvHeadline.setNestedScrollingEnabled(true);


    }


    @Override
    public boolean onSupportNavigateUp() {
        articleArrayList.clear();
        newsArticles.clear();
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if ("Indonesia".equals(parent.getItemAtPosition(position))) {
             code_country = "id";

        }else if("Argentina".equals(parent.getItemAtPosition(position))){
             code_country = "ar";

        }else if("India".equals(parent.getItemAtPosition(position))){
            code_country = "in";

        }else if("United State".equals(parent.getItemAtPosition(position))) {
            code_country = "us";

        }else if("Netherlands".equals(parent.getItemAtPosition(position))) {
            code_country = "nl";

        }else if("China".equals(parent.getItemAtPosition(position))) {
            code_country = "cn";

        }else if("Germany".equals(parent.getItemAtPosition(position))) {
            code_country = "de";
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void setNews(String codeCountry){
        newsViewModel.topHeadline(codeCountry);
        newsViewModel.getNewsRepository().observe(this, newsResponse -> {
            newsArticles = newsResponse.getArticles();
            articleArrayList.addAll(newsArticles);
            newsAdapter.notifyDataSetChanged();
        });
    }
}

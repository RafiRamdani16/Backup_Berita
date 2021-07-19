package com.example.mynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.mynews.adapter.NewsAdapter;
import com.example.mynews.model.NewsArticle;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    ArrayList<NewsArticle> articleArrayList = new ArrayList<>();
    NewsAdapter newsAdapter;
    RecyclerView rvHeadline;
    NewsViewModel newsViewModel;
    List<NewsArticle> newsArticles;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeadline = findViewById(R.id.rvNews);

        newsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
//        newsViewModel.init();
//
//        newsViewModel.getNewsRepository().observe(this, newsResponse -> {
//           newsArticles = newsResponse.getArticles();
//            articleArrayList.addAll(newsArticles);
//            newsAdapter.notifyDataSetChanged();
//        });

//        newsViewModel.getNewsEverythingFilter(" ");
//        newsViewModel.getNewsRepository().observe(this, reports -> {
//            // Update the cached copy of the words in the adapter.
//            if (reports == null){
//                return;
//            }
//            newsArticles = reports.getArticles();
//            articleArrayList.addAll(newsArticles);
//            newsAdapter.notifyDataSetChanged();
//        });



//        newsViewModel.eNews();
//        newsViewModel.getNewsRepository().observe(this, everything ->{
//            if(everything == null){
//                return;
//            }
//            newsArticles = everything.getArticles();
//            articleArrayList.addAll(newsArticles);
//            newsAdapter.notifyDataSetChanged();
//        });

        setupRecyclerView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
//        newsAdapter = new NewsAdapter(MainActivity.this, articleArrayList);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);
        MenuItem item = menu.findItem(R.id.menuSearch);
        android.widget.SearchView searchView = (android.widget.SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                if (TextUtils.isEmpty(query)) {
//                    search("");
////                    newsArticles.clearTextFilter();
//                } else {
//                    search(query);
//                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)) {
                    search("");
//                    newsArticles.clearTextFilter();
                } else {
                    search(newText);
                }
                return true;

            }
        });

        return true;
    }


    private void setupRecyclerView() {
        if (newsAdapter == null) {
            newsAdapter = new NewsAdapter(MainActivity.this, articleArrayList);
            rvHeadline.setLayoutManager(new LinearLayoutManager(this));
            rvHeadline.setAdapter(newsAdapter);
            rvHeadline.setItemAnimator(new DefaultItemAnimator());
            rvHeadline.setNestedScrollingEnabled(true);
        } else {
            newsAdapter.notifyDataSetChanged();
        }
    }

//    public void search(String charText) {
//        charText = charText.toLowerCase(Locale.getDefault());
//        articleArrayList.clear();
//        if (charText.length() == 0) {
//            articleArrayList.addAll(newsArticles);
//        } else {
//            for (NewsArticle an : newsArticles) {
//                Log.d("TESTTT","sasd");
//                if (an.getTitle().toLowerCase(Locale.getDefault()).contains(charText)) {
//                    Log.d("TESTTT","jadi");
//                    articleArrayList.add(an);
//                }
//            }
//        }
//        newsAdapter.notifyDataSetChanged();
//    }

    public void search(String charText) {
//        charText = charText.toLowerCase(Locale.getDefault());
        articleArrayList.clear();
        if (charText.length() == 0) {
            articleArrayList.addAll(newsArticles);
        } else {
            newsViewModel.getNewsEverythingFilter(charText);
            newsViewModel.getNewsRepository().observe(this, reports -> {
//            // Update the cached copy of the words in the adapter.
            if (reports == null){
                return;
            }
            newsArticles = reports.getArticles();
                articleArrayList.addAll(newsArticles);
        });

    }
        newsAdapter.notifyDataSetChanged();
    }
}
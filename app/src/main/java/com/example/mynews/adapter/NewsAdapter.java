package com.example.mynews.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mynews.DetailNews;
import com.example.mynews.FormatTime;
import com.example.mynews.model.NewsArticle;
import com.example.mynews.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    Context context;
    ArrayList<NewsArticle> articles;
    ArrayList<NewsArticle> searchArticles;

    public NewsAdapter(Context context, ArrayList<NewsArticle> articles) {
        this.context = context;
        this.articles = articles;
        this.searchArticles = new ArrayList<NewsArticle>();
        this.searchArticles.addAll(articles);
    }

    @NonNull
    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false);
        return new  NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.NewsViewHolder holder, int position) {

        holder.tvName.setText(articles.get(position).getTitle());
        holder.tvPublised.setText(FormatTime.convertTime(articles.get(position).getPublishedAt()));
        holder.tvSourceName.setText(articles.get(position).getSource().getName());
        Picasso.get().load(articles.get(position).getUrlToImage())
                .resize(1280,720)
                .into(holder.ivNews);

        holder.tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle =new Bundle();
                bundle.putString("title",articles.get(position).getTitle());
                bundle.putString("time",FormatTime.convertDetailTime(articles.get(position).getPublishedAt()));
                bundle.putString("image",articles.get(position).getUrlToImage());
                bundle.putString("publisher",articles.get(position).getSource().getName());
                bundle.putString("author",articles.get(position).getAuthor());
                bundle.putString("description",articles.get(position).getDescription());
                bundle.putString("url",articles.get(position).getUrl());

                Intent intent = new Intent(v.getContext(), DetailNews.class);
                intent.putExtras(bundle);
                v.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvPublised;
        TextView tvSourceName;
        ImageView ivNews;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPublised = itemView.findViewById(R.id.tvPublised);
            tvSourceName = itemView.findViewById(R.id.tvSource);
            ivNews = itemView.findViewById(R.id.ivNews);
        }
    }


}

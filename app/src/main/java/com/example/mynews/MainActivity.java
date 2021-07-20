package com.example.mynews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialCardView cvHead,cvWorld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cvHead = findViewById(R.id.cardHeadline);
        cvWorld = findViewById(R.id.cardWorld);

        cvHead.setOnClickListener(this);

        cvWorld.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.cardHeadline) {
            Intent intent = new Intent(MainActivity.this, CategoryCountry.class);
            startActivity(intent);
        } else if (view.getId() == R.id.cardWorld) {
            Intent intent = new Intent(MainActivity.this, WorldNewsActivity.class);
            startActivity(intent);
        }
    }

}
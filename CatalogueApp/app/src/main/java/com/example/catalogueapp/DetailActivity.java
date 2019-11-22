package com.example.catalogueapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView v = findViewById(R.id.detailTextView);

        //int index = getIntent().getExtras().getInt("index");

        Intent t = getIntent();
        String param = t.getStringExtra(MainActivity.MESSAGE);
        v.setText(param);
    }
}

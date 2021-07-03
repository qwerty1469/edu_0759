package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewingUserActivity extends AppCompatActivity {

    TextView textViewCurrentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewing_user);
        textViewCurrentUser = findViewById(R.id.textViewCurrentUser);
        Intent intent = getIntent();
        String text = intent.getStringExtra("CurrentUser");
        textViewCurrentUser.setText(text);
    }
}
package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewingUserActivity extends AppCompatActivity {

    TextView textViewInfoName;
    TextView textViewInfoLastName;
    TextView textViewInfoPhone;
    Button editBtn;
    Button deleteBtn;
    Users users;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewing_user);
        users = new Users(ViewingUserActivity.this);
        user = (User) getIntent().getSerializableExtra("CurrentUser");

        editBtn = findViewById(R.id.editBtn);
        deleteBtn = findViewById(R.id.deleteBtn);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewingUserActivity.this, UserFormActivity.class);
                intent.putExtra("CurrentUser", user);
                startActivity(intent);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                users.removeUser(user.getUuid());
                onBackPressed();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        user = users.getUserFromDB(user.getUuid());
        textViewInfoName = findViewById(R.id.textViewInfoName);
        textViewInfoLastName = findViewById(R.id.textViewInfoLastName);
        textViewInfoPhone = findViewById(R.id.textViewInfoPhone);

        textViewInfoName.setText(user.getUserName());
        textViewInfoLastName.setText(user.getUserLastName());
        textViewInfoPhone.setText(user.getPhone());
    }
}
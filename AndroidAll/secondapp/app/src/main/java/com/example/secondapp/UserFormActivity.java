package com.example.secondapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UserFormActivity extends AppCompatActivity {

    Button insertUserBtn;
    EditText editTextName;
    EditText editTextLastName;
    EditText editTextPhone;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);
        user = (User) getIntent().getSerializableExtra("CurrentUser");
        editTextName = findViewById(R.id.editTextName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextPhone = findViewById(R.id.editTextPhone);

        if (user != null) {
            editTextName.setText(user.getUserName());
            editTextLastName.setText(user.getUserLastName());
            editTextPhone.setText(user.getPhone());
        }

        insertUserBtn = findViewById(R.id.insertUserBtn);
        insertUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users users = new Users(UserFormActivity.this);
                if (user != null) {
                    setUserInfoFromView(user);
                    users.updateUser(user);
                } else {
                    User user = new User();
                    setUserInfoFromView(user);
                    users.addUser(user);
                }
                onBackPressed();
            }
        });
    }

    public void setUserInfoFromView(User user) {
        user.setUserName(editTextName.getText().toString());
        user.setUserLastName(editTextLastName.getText().toString());
        user.setUserPhone(editTextPhone.getText().toString());
    }
}
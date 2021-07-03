package com.example.secondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> userList = new ArrayList<>();
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    Button addUserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview); // получаем ссылку на компонент RecyclerView - комп., который отображает список
        // указываем как необходимо упорядочить будущее размещение списка
        // LinearLayoutManager - упорядочивает элементы в виде списка с одной колонкой
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        addUserBtn = findViewById(R.id.addUserBtn);
        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserFormActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerViewInit();
    }

    private void recyclerViewInit() {
        Users users = new Users(MainActivity.this);
        userList = users.getUserList();
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }

    private class UserHolder extends RecyclerView.ViewHolder { // ViewHolder - элемент списка
        TextView itemTextView;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {   // конструктор. Inflater - раздувает макет
            super(inflater.inflate(R.layout.single_item, viewGroup, false));
            itemTextView = itemView.findViewById(R.id.itemTextView);    // itemView - текущий layout single_item
            itemTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ViewingUserActivity.class);
                    intent.putExtra("CurrentUser", itemTextView.getText());
                    startActivity(intent);
                }
            });
        }

        public void bind (String userString){ itemTextView.setText(userString); }

    }

    private class UserAdapter extends RecyclerView.Adapter<UserHolder> {    // Adapter - помещает элементы списка на RecyclerView
        ArrayList<User> users;
        public UserAdapter(ArrayList<User> users) {
            this.users = users;
        }

        @NonNull
        @Override
        public UserHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) { // Метод для создания нового ViewHolder (элемента списка)
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);   // раздувает макет
            return new UserHolder(inflater, viewGroup);
        }

        // Извлекает данные пользователя-контакта и передает во ViewHolder через его метод bind()
        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            User user = users.get(position);
            String userString = user.getUserName()+ " " + user.getUserLastName() + "\n" + user.getPhone();
            userHolder.bind(userString);
        }

        @Override
        public int getItemCount() { // Возвращает кол-во объектов в коллекции ArrayList для размещения
            return users.size();
        }
    }
}
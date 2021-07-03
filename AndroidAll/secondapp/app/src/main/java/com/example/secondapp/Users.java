package com.example.secondapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;

import com.example.secondapp.database.UserBaseHelper;
import com.example.secondapp.database.UserDBSchema;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> userList;
    private SQLiteDatabase database;
    private Context context;

    public Users(Context context) {
        this.context = context.getApplicationContext();
        this.database = new UserBaseHelper(context).getWritableDatabase();
    }

    public void addUser(User user) {
        ContentValues values = getContentValues(user);
        database.insert(UserDBSchema.UserTable.NAME, null, values);
    }

    private static ContentValues getContentValues(User user) {
        ContentValues values = new ContentValues();
        // Сопоставляем колонки и свойства объекта User
        values.put(UserDBSchema.Cols.UUID, user.getUuid().toString());
        values.put(UserDBSchema.Cols.USERNAME, user.getUserName());
        values.put(UserDBSchema.Cols.USERLASTNAME, user.getUserLastName());
        values.put(UserDBSchema.Cols.PHONE, user.getPhone());
        return values;
    }

    private UserCursorWrapper queryUsers() {
        Cursor cursor = database.query(UserDBSchema.UserTable.NAME, null, null, null, null, null, null);
        return new UserCursorWrapper(cursor);
    }

    public ArrayList<User> getUserList() {
        this.userList = new ArrayList<User>();
        UserCursorWrapper cursorWrapper = queryUsers();
        try {
            cursorWrapper.moveToFirst();
            while (!cursorWrapper.isAfterLast()) {
                User user = cursorWrapper.getUser();
                userList.add(user);
                cursorWrapper.moveToNext();
            }
        }finally {
            System.out.println("Исключение CursorWrapper. Закрытие");
            cursorWrapper.close();
        }
        return userList;
    }
}

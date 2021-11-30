package com.example.lifetrack1.utils;

import android.app.Application;

import androidx.room.Room;

import com.example.lifetrack1.room.AppDataBase;

public class App extends Application {
    public static App instance;

    private AppDataBase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDataBase.class, "database").allowMainThreadQueries()
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDataBase getDatabase() {
        return database;
    }
}

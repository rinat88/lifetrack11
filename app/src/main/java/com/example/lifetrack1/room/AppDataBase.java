package com.example.lifetrack1.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.lifetrack1.model.TaskModel;

@Database(entities = {TaskModel.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract TaskDao taskDao();
}

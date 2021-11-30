package com.example.lifetrack1.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lifetrack1.model.TaskModel;

import java.util.List;


@Dao
public interface TaskDao {
    @Insert
    void insert(TaskModel model);

    @Query("SELECT * FROM taskmodel")
    LiveData<List<TaskModel>> getAll();

    @Delete
    void delete(TaskModel taskModel);
    @Update
    void update(TaskModel model);
}

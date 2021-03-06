package com.example.lifetrack1.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class TaskModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public long id;
    String task;
    String deadline;
    String repeatCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TaskModel(String task, String deadline, String repeatCount) {
        this.task = task;
        this.deadline = deadline;
        this.repeatCount = repeatCount;
    }

    public String getTask() {
        return task;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getRepeatCount() {
        return repeatCount;
    }
}

package com.example.lifetrack1;

import com.example.lifetrack1.model.TaskModel;

public interface OnLongItemListener {
    void itemLongClick(TaskModel taskModel);
    void itemClick(TaskModel model);
}

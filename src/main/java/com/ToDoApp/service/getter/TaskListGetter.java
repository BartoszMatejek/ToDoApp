package com.ToDoApp.service.getter;

import com.ToDoApp.model.TaskList;

public interface TaskListGetter {
    TaskList getTaskList(Integer taskListId, Integer userId);
}

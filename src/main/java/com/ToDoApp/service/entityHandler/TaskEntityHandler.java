package com.ToDoApp.service.entityHandler;

import com.ToDoApp.dto.request.TaskCreateDTO;
import com.ToDoApp.model.Task;

public interface TaskEntityHandler {
    Task prepareTask(TaskCreateDTO taskCreateDTO, Integer taskListId, Integer userId);

    Task saveTask(Task task);

    void deleteTask(Integer userId, Integer taskListId, Integer taskId);
}

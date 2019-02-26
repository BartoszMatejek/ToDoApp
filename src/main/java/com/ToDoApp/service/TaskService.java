package com.ToDoApp.service;

import com.ToDoApp.dto.request.TaskCreateDTO;
import com.ToDoApp.dto.response.SingleValueDTO;

public interface TaskService {

    SingleValueDTO<Integer> createTask(Integer userId, Integer taskListId, TaskCreateDTO taskCreateDTO);

    void deleteTask(Integer userId, Integer taskListId, Integer taskId);
}

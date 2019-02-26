package com.ToDoApp.service.impl;

import com.ToDoApp.dto.request.TaskCreateDTO;
import com.ToDoApp.dto.response.SingleValueDTO;
import com.ToDoApp.model.Task;
import com.ToDoApp.service.TaskService;
import com.ToDoApp.service.entityHandler.TaskEntityHandler;
import com.ToDoApp.validator.TaskValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskValidator taskValidator;

    private TaskEntityHandler taskEntityHandler;

    public TaskServiceImpl(
            TaskValidator taskValidator,
            TaskEntityHandler taskEntityHandler) {
        this.taskValidator = taskValidator;
        this.taskEntityHandler = taskEntityHandler;
    }

    @Override
    @Transactional
    public SingleValueDTO<Integer> createTask(Integer userId, Integer taskListId, TaskCreateDTO taskCreateDTO) {
        taskValidator.validateTaskCreation(taskCreateDTO);
        Task taskToSave = taskEntityHandler.prepareTask(taskCreateDTO, taskListId, userId);
        Task savedTask = taskEntityHandler.saveTask(taskToSave);
        return new SingleValueDTO<>(savedTask.getId());
    }

    @Override
    public void deleteTask(Integer userId, Integer taskListId, Integer taskId) {
        taskEntityHandler.deleteTask(userId, taskListId, taskId);
    }
}
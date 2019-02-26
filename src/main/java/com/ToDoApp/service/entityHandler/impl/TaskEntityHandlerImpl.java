package com.ToDoApp.service.entityHandler.impl;

import com.ToDoApp.dto.request.TaskCreateDTO;
import com.ToDoApp.exception.InternalServerErrorException;
import com.ToDoApp.exception.ResourceNotFoundException;
import com.ToDoApp.service.getter.TaskListGetter;
import com.ToDoApp.model.Task;
import com.ToDoApp.model.TaskList;
import com.ToDoApp.repository.TaskRepository;
import com.ToDoApp.service.entityHandler.TaskEntityHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TaskEntityHandlerImpl implements TaskEntityHandler {

    private TaskListGetter taskListGetter;

    private TaskRepository taskRepository;

    public TaskEntityHandlerImpl(
            TaskListGetter taskListGetter,
            TaskRepository taskRepository) {
        this.taskListGetter = taskListGetter;
        this.taskRepository = taskRepository;
    }

    @Override
    public Task prepareTask(TaskCreateDTO taskCreateDTO, Integer taskListId, Integer userId) {
        TaskList taskList = taskListGetter.getTaskList(taskListId, userId);
        if (taskList != null) {
            Task task = new Task();
            task.setDescription(taskCreateDTO.getDescription().trim());
            task.setTaskList(taskList);
            return task;
        } else {
            throw new ResourceNotFoundException(
                    "User tried to edit taskList that does not exist or has no permission to edit");
        }
    }

    @Override
    public Task saveTask(Task taskToSave) {
        try {
            return taskRepository.save(taskToSave);
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }
    }

    @Override
    @Transactional
    public void deleteTask(Integer userId, Integer taskListId, Integer taskId) {
        try {
            taskRepository.deleteByIdAndTaskListIdAndTaskListUserId(taskId, taskListId, userId);
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }
    }
}
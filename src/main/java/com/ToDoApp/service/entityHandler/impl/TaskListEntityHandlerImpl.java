package com.ToDoApp.service.entityHandler.impl;

import com.ToDoApp.exception.InternalServerErrorException;
import com.ToDoApp.repository.TaskListRepository;
import com.ToDoApp.service.entityHandler.TaskListEntityHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TaskListEntityHandlerImpl implements TaskListEntityHandler {

    private TaskListRepository taskListRepository;

    public TaskListEntityHandlerImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    @Transactional
    public void deleteList(Integer taskListId, Integer userId) {
        try {
            taskListRepository.deleteTaskListByIdAndUserId(taskListId, userId);
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }
    }
}

package com.ToDoApp.service;

import com.ToDoApp.dto.request.TaskListCreateDTO;
import com.ToDoApp.dto.response.ListDTO;
import com.ToDoApp.dto.response.SingleValueDTO;
import com.ToDoApp.dto.response.TaskListBasicDTO;
import com.ToDoApp.dto.response.TaskListExtendedDTO;

public interface TaskListService {

    SingleValueDTO<Integer> createList(Integer userId, TaskListCreateDTO taskListCreateDTO);

    ListDTO<TaskListBasicDTO> getAllTaskLists(Integer userId);

    void deleteList(Integer taskListId, Integer userId);

    TaskListExtendedDTO getTaskList(Integer taskListId, Integer userId);
}
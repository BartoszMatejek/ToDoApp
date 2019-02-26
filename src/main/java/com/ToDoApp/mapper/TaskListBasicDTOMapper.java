package com.ToDoApp.mapper;

import com.ToDoApp.dto.response.TaskListBasicDTO;
import com.ToDoApp.model.TaskList;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskListBasicDTOMapper {

    TaskListBasicDTO taskListToTaskListBasicDTO(TaskList taskList);

    List<TaskListBasicDTO> taskListsToTaskListBasicDTOs(List<TaskList> taskLists);
}

package com.ToDoApp.mapper;

import com.ToDoApp.dto.response.TaskDTO;
import com.ToDoApp.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskDTOMapper {

    TaskDTO taskToTaskDataDTO(Task task);

    List<TaskDTO> tasksToTaskDataDTOs(List<Task> tasks);
}

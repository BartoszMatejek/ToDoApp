package com.ToDoApp.mapper;

import com.ToDoApp.dto.request.TaskListCreateDTO;
import com.ToDoApp.model.TaskList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TaskListCreateDTOMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "user", ignore = true),
            @Mapping(target = "listOfTasks", ignore = true)
    })
    TaskList taskListCreateDTOToTaskList(TaskListCreateDTO taskListCreateDTO);
}
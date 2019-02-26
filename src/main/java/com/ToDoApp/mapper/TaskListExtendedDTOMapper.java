package com.ToDoApp.mapper;

import com.ToDoApp.dto.response.TaskListExtendedDTO;
import com.ToDoApp.model.TaskList;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TaskListExtendedDTOMapper {

    @Mappings({
            @Mapping(source = "listOfTasks", target = "listOfTasks")
    })
    TaskListExtendedDTO taskListToTaskListExtendedDTO(TaskList taskList);
}

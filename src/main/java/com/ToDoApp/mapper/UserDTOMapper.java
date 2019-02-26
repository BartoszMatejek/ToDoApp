package com.ToDoApp.mapper;

import com.ToDoApp.dto.request.UserCreateDTO;
import com.ToDoApp.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {

    User userCreateDTOToUser(UserCreateDTO userCreateDTO);
}

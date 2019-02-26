package com.ToDoApp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreateDTO {
    @JsonProperty(value = "login")
    private String login;
    @JsonProperty(value = "password")
    private String passwordHash;
}

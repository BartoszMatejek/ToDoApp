package com.ToDoApp.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SingleValueDTO<T> {
    @JsonProperty("value")
    private T value;
}

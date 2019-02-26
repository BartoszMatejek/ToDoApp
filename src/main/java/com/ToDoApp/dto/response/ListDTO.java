package com.ToDoApp.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListDTO<T> {
    @JsonProperty("list")
    private List<T> list;
}

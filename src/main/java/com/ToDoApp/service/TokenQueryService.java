package com.ToDoApp.service;


import javax.servlet.http.HttpServletRequest;

public interface TokenQueryService {

    Integer getUserId(HttpServletRequest request);
}

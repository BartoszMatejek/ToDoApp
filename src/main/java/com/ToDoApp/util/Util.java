package com.ToDoApp.util;

public class Util {

    public static boolean isNullOrBlank(String input) {
        return input == null
                || input.trim().isEmpty();
    }
}

package com.task.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class TaskRequest {
    private String name;
    private String description;
    private Boolean done;
}

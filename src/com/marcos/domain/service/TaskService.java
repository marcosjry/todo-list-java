package com.marcos.domain.service;

import com.marcos.domain.DTO.TaskDTO;
import com.marcos.domain.model.Task;

import java.security.InvalidParameterException;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public interface TaskService {

    Task createTask(TaskDTO task) throws InvalidParameterException;

    void createTaskOnMain(Scanner scanner, LinkedList<Task> tasks, DateTimeFormatter formatter);

    LinkedList<Task> getTasksByFilter(LinkedList<Task> tasks, String filter);
}

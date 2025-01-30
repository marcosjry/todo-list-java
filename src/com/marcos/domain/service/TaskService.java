package com.marcos.domain.service;

import com.marcos.domain.DTO.TaskDTO;
import com.marcos.domain.exception.TaskNameAlreadyExistException;
import com.marcos.domain.model.Task;

import java.security.InvalidParameterException;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Function;

public interface TaskService {

    Task createTask(TaskDTO task) throws InvalidParameterException;

    void createTaskOnMain(Scanner scanner, LinkedList<Task> tasks, DateTimeFormatter formatter) throws TaskNameAlreadyExistException;

    LinkedList<Task> getTasksByFilter(LinkedList<Task> tasks, Function<Task, ?> propertyExtractor, Object filterValue);

    void showListAfterFilter(LinkedList<Task> tasks, LinkedList<Task> afterFilter );

    void deleteTaskByName(String name, LinkedList<Task> tasks);

}

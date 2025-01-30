package com.marcos.domain.service.impl;

import com.marcos.domain.DTO.TaskDTO;
import com.marcos.domain.model.Task;
import com.marcos.domain.model.TaskStatus;
import com.marcos.domain.service.TaskService;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {

    @Override
    public Task createTask(TaskDTO taskDTO) {
        var isValid = checkIfIsValid(taskDTO);
        if (isValid) {

            return new Task(
                    UUID.randomUUID().toString(),
                    taskDTO.name(),
                    taskDTO.description(),
                    taskDTO.dateEnd(),
                    taskDTO.priority(),
                    taskDTO.status().toString(),
                    taskDTO.category()
            );
        }
        throw new InvalidParameterException("Task parameter is invalid.");
    }

    private boolean checkIfIsValid(TaskDTO taskDTO) {
        return (isNullOrEmpty(taskDTO.name())
                && isNullOrEmpty(taskDTO.category())
                && isInputValue(taskDTO.priority())
                && isNullOrEmpty(taskDTO.description())
                && isNullOrEmpty(taskDTO.status().getStatus())
        );
    }

    public boolean isNullOrEmpty(String value) {
        return value != null && !value.isEmpty();
    }

    public boolean isInputValue(int value) {
        return value >= 1 && value <= 5;
    }

    public void checkOnMain(Object object, String type) throws InvalidParameterException {
        if (type.equals("number")) {
            int intCheck = (int) object;
            boolean isValid = isInputValue(intCheck);
            if (!isValid) {
                throw new InvalidParameterException("Int value is Bigger than 5 or smaller than 1.");
            }
        } else if (type.equals("text")) {
            String textCheck = (String) object;
            boolean isValid = isNullOrEmpty(textCheck);
            if (!isValid) {
                throw new InvalidParameterException("text value is invalid.");
            }
        }

    }

    @Override
    public void createTaskOnMain(Scanner scanner, LinkedList<Task> tasks, DateTimeFormatter formatter) {

        System.out.println("Dê um nome pra sua Task");
        String name = scanner.nextLine();
        checkOnMain(name, "text");

        System.out.println("Insira uma Descrição");
        String description = scanner.nextLine();
        checkOnMain(description, "text");

        System.out.println("Digite uma Categoria para a Task");
        String category = scanner.nextLine();
        checkOnMain(category, "text");

        System.out.println("Qual deve ser a prioridade da task? [1 a 5]");
        String priorityFromUser = scanner.nextLine();
        int priority = Integer.parseInt(priorityFromUser);
        checkOnMain(priority, "number");

        System.out.println("Informe a data de término da Task (dd/MM/yyyy).");
        String date = scanner.nextLine();
        LocalDate endDate = LocalDate.parse(date, formatter);

        System.out.println("\n\nCriando Task...\n\n");

        tasks.add(
                createTask(
                        new TaskDTO(name,
                                description,
                                endDate,
                                priority,
                                TaskStatus.TODO,
                                category)
                )
        );

        System.out.println("Task Criada com sucesso!");
        tasks.forEach(System.out::println);
    }

    // Agora o método faz uso de uma Function pra conseguir filtrar por propriedade da Task
    // Mais fácil de reutilizar para novos filtros no futuro
    @Override
    public LinkedList<Task> getTasksByFilter(LinkedList<Task> tasks, Function<Task, ?> propertyExtractor, Object filterValue) {
        return tasks.stream()
                .filter(task -> filterValue.equals(propertyExtractor.apply(task)))
                .sorted((t1, t2) -> Integer.compare(t1.getPriority(), t2.getPriority()))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public void showListAfterFilter(LinkedList<Task> tasks, LinkedList<Task> afterFilter ) {
        if(afterFilter.isEmpty()) {
            System.out.println("Não existe nenhuma task com esse filtro.");
        }
        System.out.println("\nLista de Tasks Filtrada:\n");
        afterFilter.forEach(task -> task.showTaskInfo(tasks.indexOf(task)));
    }
}



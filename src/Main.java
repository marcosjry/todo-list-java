
import com.marcos.domain.exception.TaskNameAlreadyExistException;
import com.marcos.domain.model.Task;
import com.marcos.domain.model.TaskStatus;
import com.marcos.domain.service.TaskService;
import com.marcos.domain.service.impl.CustomFile;
import com.marcos.domain.service.impl.TaskServiceImpl;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedList<Task> tasks = CustomFile.loadTaskFromFile("TODO-TASK-LIST.txt");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        TaskService taskService = new TaskServiceImpl();

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        do {
            System.out.println("\n\nTODO-List --------------");
            System.out.println("    [Criar Task]     [1]");
            System.out.println("    [Excluir Task]   [2]");
            System.out.println("--- Listar Tasks por ---");
            System.out.println("    [Categoria]      [3]");
            System.out.println("    [Prioridade]     [4]");
            System.out.println("    [Status]         [5]");
            System.out.println("------------------------");
            System.out.println("[Sair]               [0]");

            String userInput = scanner.nextLine();
            int toCheck = Integer.parseInt(userInput);
            try {

                switch (toCheck) {
                    case 1:
                        taskService.createTaskOnMain(scanner, tasks, formatter);
                        break;
                    case 2:
                        System.out.println("Qual task você quer remover?");
                        String taskNameToRemove = scanner.nextLine();
                        taskService.deleteTaskByName(taskNameToRemove, tasks);
                        break;
                    case 3:
                        System.out.println("Por qual categoria você quer filtrar?");
                        String category = scanner.nextLine();
                        var filteredCategories = taskService.getTasksByFilter(
                                tasks,
                                Task::getCategory,
                                category.toLowerCase());
                        taskService.showListAfterFilter(tasks, filteredCategories);
                        break;
                    case 4:
                        System.out.println("Por qual Prioridade você quer filtrar?");
                        String priorityStr = scanner.nextLine();
                        int priority = Integer.parseInt(priorityStr);
                        var filteredPriorities = taskService.getTasksByFilter(
                                tasks,
                                Task::getPriority,
                                priority);
                        taskService.showListAfterFilter(tasks, filteredPriorities);
                        break;
                    case 5:
                        System.out.println("Por qual Status você quer filtrar?");
                        String status = scanner.nextLine();
                        var filteredStatus = taskService.getTasksByFilter(
                                tasks,
                                Task::getStatus,
                                status.toLowerCase());
                        taskService.showListAfterFilter(tasks, filteredStatus);
                        break;
                    case 0:
                        CustomFile.saveFile(tasks, "TODO-TASK-LIST.txt");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("\nErro. Provavelmente você está passando um input inválido. \n[Input] = " + toCheck + " \n\nPorfavor, use um input válido e tente novamente.\n\n");
                        Thread.sleep(300);
                }
            } catch (InvalidParameterException | IOException |InterruptedException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("Status inválido.");
            } catch (TaskNameAlreadyExistException e) {
                System.out.println("\n"+ e.getMessage() + " porfavor declare uma nova.");
            }
        } while (isRunning);
    }
}
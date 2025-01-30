
import com.marcos.domain.model.Task;
import com.marcos.domain.service.TaskService;
import com.marcos.domain.service.impl.CustomFile;
import com.marcos.domain.service.impl.TaskServiceImpl;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedList<Task> tasks = CustomFile.loadTaskFromFile("TODO-TASK-LIST.txt");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        TaskService taskService = new TaskServiceImpl();

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        do {
            System.out.println("TODO-List --------------");
            System.out.println("    [Criar Task]     [1]");
            System.out.println("--- Listar Tasks por ---");
            System.out.println("    [Categoria]      [2]");
            System.out.println("    [Prioridade]     [3]");
            System.out.println("    [Status]         [4]");
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
                        System.out.println("Por qual categoria você quer filtrar?");
                        String category = scanner.nextLine();
                        var filteredTasks = taskService.getTasksByFilter(tasks, category);
                        filteredTasks.forEach(System.out::println);
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
            }
        } while (isRunning);

    }


}
package com.marcos.domain.service.impl;

import com.marcos.domain.model.Task;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class CustomFile {

    public static void saveFile(LinkedList<Task> tasks, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false));
        for (Task task : tasks) {
              writer.write(task.toString() + "\n");
        }
        writer.close();
    }

    public static LinkedList<Task> loadTaskFromFile(String fileName) {
        try {
            StringBuilder content = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            String[] data = content.toString().split("\n");
            LinkedList<Task> tasks = new LinkedList<>();
            for (String lineTask: data) {
                var task = getTaskFromObject(lineTask);
                tasks.add(task);
            }
            return tasks;
        } catch (IOException e) {
            return new LinkedList<>();
        }
    }

    //id + name + description + dateEnd + priority + status + category;
    public static Task getTaskFromObject(String task) {
        String[] taskInfo = task.split(";");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String id = taskInfo[0].trim();
        String name = taskInfo[1].trim();
        String description = taskInfo[2].trim();
        String date = taskInfo[3].trim();
        LocalDate formatedDate = LocalDate.parse(date, formatter);
        int priority = Integer.parseInt(taskInfo[4].trim());
        String status = taskInfo[5].trim();
        String category = taskInfo[6].trim();

        return new Task(id, name, description, formatedDate, priority, status, category);
    }

}

package com.marcos.domain.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {

    private String id;
    private String name;
    private String description;
    private LocalDate dateEnd;
    private int priority;
    private TaskStatus status;
    private String category;

    public Task (String id, String name, String description, LocalDate dateEnd, int priority, String status, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateEnd = dateEnd;
        this.priority = priority;
        this.status = TaskStatus.valueOf(status);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "; " + name + "; " + description + "; " + dateEnd + "; " + priority + "; " + status + "; " + category;
    }
}

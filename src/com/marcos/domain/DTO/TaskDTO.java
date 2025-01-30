package com.marcos.domain.DTO;

import com.marcos.domain.model.TaskStatus;

import java.time.LocalDate;

public record TaskDTO(String name, String description, LocalDate dateEnd, int priority, TaskStatus status, String category) {
}

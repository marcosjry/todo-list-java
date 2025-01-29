package com.marcos.domain.model;

public enum TaskStatus {
    TODO("todo"),
    DOING("doing"),
    DONE("done");

    TaskStatus(String status) { this.status = status; }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

}

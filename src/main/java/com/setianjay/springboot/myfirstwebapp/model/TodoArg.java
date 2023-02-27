package com.setianjay.springboot.myfirstwebapp.model;

import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TodoArg {
    private String username;
    @Size(min = 5, message = "Description consists of at least 5 characters")
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate targetDate;
    private boolean done;

    public TodoArg(String username, String description, LocalDate targetDate, boolean done) {
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.done = done;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo{" +
                ", username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", isDone=" + done +
                '}';
    }
}

package com.siddharth.data.entity;

import com.siddharth.utilities.Status;
import com.siddharth.utilities.TaskType;

public abstract class Task {
    private Status status;
    private String name;
    private User assignee;
    private int number;
    private TaskType taskType;
    private static int autoGen = 1;

    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public User getAssignee() {
        return assignee;
    }

    public Task(String name, TaskType taskType) {
        this.name = name;
        this.assignee = null;
        this.status = Status.NEW;
        this.taskType = taskType;
        this.number = autoGen++;
    }

    public void setStatus(int i) {
        this.status = Status.values()[i];
    }
}

package com.siddharth.data.entity;

import java.util.ArrayList;
import java.util.Date;

public class Sprint {
    private int sprintNumber;
    private String sprintName;
    ArrayList<Task> tasks;

    public Sprint(int sprintNumber, String sprintName) {
        this.sprintNumber = sprintNumber;
        this.sprintName = sprintName;
        this.tasks = new ArrayList<>();
    }

    public int getSprintNumber() {
        return sprintNumber;
    }

    public String getSprintName() {
        return sprintName;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}

package com.siddharth.data.entity;

import com.siddharth.utilities.TaskType;

public class Story extends Task {
    private int points;

    public Story(String name, TaskType taskType, int points) {
        super(name, taskType);
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}

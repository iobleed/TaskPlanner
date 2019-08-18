package com.siddharth.data.entity;

import com.siddharth.utilities.TaskType;

public class Feature extends Task {
    private String releaseVersion;

    public Feature(String name, TaskType taskType, String releaseVersion) {
        super(name, taskType);
        this.releaseVersion = releaseVersion;
    }
}

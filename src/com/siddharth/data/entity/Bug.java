package com.siddharth.data.entity;

import com.siddharth.utilities.Severity;
import com.siddharth.utilities.TaskType;

public class Bug extends Task {
    private Severity severity;

    public Bug(String name, TaskType taskType, Severity severity) {
        super(name, taskType);
        this.severity = severity;
    }
}

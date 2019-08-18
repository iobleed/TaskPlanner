package com.siddharth.data.repository;

import com.siddharth.data.entity.Sprint;
import com.siddharth.data.entity.Task;
import com.siddharth.data.entity.User;

import java.util.ArrayList;

public class AppRepository {
    private ArrayList<User> users;
    private ArrayList<Task> tasks;
    private ArrayList<Sprint> sprints;

    public AppRepository() {
        this.users = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.sprints = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public ArrayList<Sprint> getSprints() {
        return sprints;
    }
}

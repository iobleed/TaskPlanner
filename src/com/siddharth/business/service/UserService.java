package com.siddharth.business.service;

import com.siddharth.TaskPlannerApplication;
import com.siddharth.controller.CliController;
import com.siddharth.data.entity.Task;
import com.siddharth.data.entity.User;

import java.util.ArrayList;

public class UserService {

    private TaskPlannerApplication app = TaskPlannerApplication.getInstance();

    public void listUser(){
        ArrayList<User> users = app.getAppRepository().getUsers();
        if(users.isEmpty()){
            System.out.println("No user found. Add some users.");
            return;
        }
        System.out.println("User List\nS.No.\tFist Name\tLast Name\n");
        users.forEach( user -> {
            int i = 1;
            System.out.println(i++ +". " + user.getFirstName() + " " + user.getLastName());
        });
    }

    public void addUser(){
        System.out.println("Add new User");
        ArrayList<User> users = app.getAppRepository().getUsers();
        System.out.println("Enter First Name");
        String firstName = app.getScanner().nextLine();
        System.out.println("Enter Last Name");
        String lastName = app.getScanner().nextLine();
        User user = new User(firstName, lastName);
        users.add(user);
        System.out.println("User Added Successfully");
        listUser();
    }

    public User selectUser(){
        System.out.println("Select User");
        listUser();
        int selection = Integer.parseInt(app.getScanner().nextLine()) - 1;
        ArrayList<User> users = app.getAppRepository().getUsers();
        return users.get(selection);
    }
}

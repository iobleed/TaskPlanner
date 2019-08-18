package com.siddharth.controller;

import com.siddharth.TaskPlannerApplication;
import com.siddharth.business.service.SprintService;
import com.siddharth.business.service.TaskService;
import com.siddharth.business.service.UserService;
import com.siddharth.data.entity.User;

public class CliController {
    TaskPlannerApplication app = TaskPlannerApplication.getInstance();
    public void execute(){
        int choice = 0;

       /* UserService userService = app.getUserService();
        SprintService sprintService = app.getSprintService();
        TaskService taskService = app.getTaskService();*/

        UserService userService = new UserService();
        SprintService sprintService = new SprintService();
        TaskService taskService = new TaskService();

        System.out.println("Running Task Planner\n");
        do{
            System.out.println("====Dashboard====");
            sprintService.listSprint();

            System.out.println("Select choice:\n" +
                    "1. Add User\n" +
                    "2. Create Task\n" +
                    "3. Create Sprint\n" +
                    "4. User Details\n" +
                    "5. Task Details\n" +
                    "6. Sprint Details\n" +
                    "0. Exit");

            choice = Integer.parseInt( app.getScanner().nextLine());
            switch (choice){
                case 1:
                    userService.addUser();
                    break;
                case 2:
                    taskService.newTask();
                    break;
                case 3:
                    sprintService.addSprint();
                    break;
                case 4:
                    User user = userService.selectUser();
                    taskService.userListTasks(user);
                    break;
                case 5:
                    taskService.taskDetails();
                    break;
                case 6:
                    sprintService.sprintDetails();
                    break;
            }
        }while(choice != 0);
        System.out.println("Application Stopped");
    }
}

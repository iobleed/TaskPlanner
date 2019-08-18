package com.siddharth.business.service;

import com.siddharth.TaskPlannerApplication;
import com.siddharth.data.entity.*;
import com.siddharth.utilities.Severity;
import com.siddharth.utilities.TaskType;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskService {

    private TaskPlannerApplication app = TaskPlannerApplication.getInstance();
    private Scanner scan = app.getScanner();
    public void listTasks(){
        ArrayList<Task> tasks = app.getAppRepository().getTasks();
        if(tasks.isEmpty()){
            System.out.println("No Sprints found. Add some sprints.");
            return;
        }
        System.out.println("Tasks\nS.No.\tTask Number\tTask Name");
        tasks.forEach( task -> {
            int i = 1;
            System.out.println((i++) + "\t" + task.getNumber() +"\t" + task.getName()
            + "\t" + task.getStatus() + "\t" + task.getTaskType() + "\t" +
                    ((task.getAssignee()==null)?"Unassigned":task.getAssignee().getFirstName()) );
        });
    }

    public void userListTasks(User user){
        ArrayList<Task> tasks = app.getAppRepository().getTasks();
        if(tasks.isEmpty()){
            System.out.println("No Sprints found. Add some sprints.");
            return;
        }
        System.out.println("User " + user.getFirstName() + " Tasks\nTask Number\tTask Name");
        tasks.forEach( task -> {
            if(task.getAssignee() == user)
            System.out.println( task.getNumber() +"\t" + task.getName()
                    + "\t" + task.getStatus() + "\t" + task.getTaskType()  );
        });
    }

    public Task selectTask(){
        System.out.println("Select Task");
        listTasks();
        int selection = Integer.parseInt(app.getScanner().nextLine());
        ArrayList<Task> tasks = app.getAppRepository().getTasks();
        return tasks.get(selection-1);
    }

    public void taskDetails(){
        Task task = selectTask();
       //UserService userService = new UserService();
        int choice = 0;
        do {
            System.out.println( task.getNumber() +"\t" + task.getName()
                    + "\t" + task.getStatus() + "\t" + task.getTaskType()  );

            System.out.println("Enter Choice\n" +
                    "1. Change assignee\n" +
                    "2. Change status\n" +
                    "0. Back");
            choice = Integer.parseInt( app.getScanner().nextLine() );
            switch (choice){
                case 1:
                    User user =  app.getUserService().selectUser();
                    //User user =  userService.selectUser();
                    task.setAssignee(user);
                    break;
                case 2:
                    System.out.println("Select Status\n" + "0. NEW\n" + "1. IN_PROGRESS\n" + "2. DONE\n" +
                            "3. REJECTED\n" + "4. CLOSED\n");
                    int selection = Integer.parseInt(app.getScanner().nextLine());
                    task.setStatus(selection);
            }
        }while(choice!=0);
    }

    public void newTask(){
        System.out.println("Add new Task");
        ArrayList<Task> tasks = app.getAppRepository().getTasks();
        System.out.println("Choose Type of Task\n" +
                "1. Bug" +
                "2. Feature" +
                "3. Story");
        int ttype = Integer.parseInt(app.getScanner().nextLine());
        if(ttype==1){
            System.out.println("Enter Bug name");
            String bugName = scan.nextLine();
            System.out.println("Enter Severity 0-2");
            int sev = Integer.parseInt(scan.nextLine());
            Bug bug = new Bug(bugName, TaskType.values()[0], Severity.values()[sev]);
            tasks.add(bug);
        }
        if(ttype==2){
            System.out.println("Enter Feature name");
            String featureName = scan.nextLine();
            System.out.println("Enter release version");
            String ver = scan.nextLine();
            Feature feature = new Feature(featureName, TaskType.values()[1], ver);
            tasks.add(feature);
        }
        if(ttype==3){
            System.out.println("Enter Story name");
            String storyName = scan.nextLine();
            System.out.println("Enter story points");
            int points = Integer.parseInt(scan.nextLine());
            Story story = new Story(storyName, TaskType.values()[2], points);
            tasks.add(story);
        }
        System.out.println("Task Added Successfully");
        listTasks();
    }
}

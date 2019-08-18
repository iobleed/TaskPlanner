package com.siddharth.business.service;

import com.siddharth.TaskPlannerApplication;
import com.siddharth.data.entity.Sprint;
import com.siddharth.data.entity.Task;

import java.util.ArrayList;

public class SprintService {

    private TaskPlannerApplication app = TaskPlannerApplication.getInstance();
    public void listSprint(){
        ArrayList<Sprint> sprints = app.getAppRepository().getSprints();
        if(sprints.isEmpty()){
            System.out.println("No Sprints found. Add some sprints.");
            return;
        }
        System.out.println("Active Sprints\nS.No.\tSprint Number\tSprint Name\n");
        sprints.forEach( sprint -> {
            int i = 1;
            System.out.println((i++) + "\t" + sprint.getSprintNumber() +"\t" + sprint.getSprintName());
        });
    }

    public void addSprint(){
        System.out.println("Add New Sprint");
        ArrayList<Sprint> sprints = app.getAppRepository().getSprints();
        System.out.println("Enter Sprint Number");
        int sprintNum = Integer.parseInt(app.getScanner().nextLine());
        System.out.println("Enter Sprint Name");
        String sprintName = app.getScanner().nextLine();
        Sprint sprint = new Sprint(sprintNum, sprintName);
        sprints.add(sprint);
        listSprint();
    }

    public Sprint selectSprint(){
        System.out.println("Select Sprint");
        listSprint();
        int selection = Integer.parseInt(app.getScanner().nextLine());
        return app.getAppRepository().getSprints().get(selection-1);
    }

    public void sprintDetails(){
        Sprint sprint = selectSprint();
        ArrayList<Task> tasks = sprint.getTasks();
       // TaskService taskService = new TaskService();
        int choice = 0;
        do{
            System.out.println("Active Sprints\nS.No.\tSprint Number\tSprint Name\n");
            System.out.println( sprint.getSprintNumber() +"\t" + sprint.getSprintName());
            System.out.println("Tasks\nS.No.\tTask Number\tTask Name");
            tasks.forEach(task -> {
                int i = 1;
                System.out.println((i++) + "\t" + task.getNumber() +"\t" + task.getName()
                        + "\t" + task.getStatus() + "\t" + task.getTaskType() + "\t" +
                        ((task.getAssignee()==null)?"Unassigned":task.getAssignee().getFirstName()) );
            });

            System.out.println("Enter choice\n" +
                    "1. Add task to sprint\n" +
                    "0. Back");
            choice = Integer.parseInt(app.getScanner().nextLine());
            if(choice==1){
                Task task = app.getTaskService().selectTask();
                //Task task = taskService.selectTask();
                tasks.add(task);
            }
        }while (choice != 0);
    }
}

package com.siddharth;

import com.siddharth.business.service.SprintService;
import com.siddharth.business.service.TaskService;
import com.siddharth.business.service.UserService;
import com.siddharth.controller.CliController;
import com.siddharth.data.repository.AppRepository;

import java.util.Scanner;

public class TaskPlannerApplication {
    private static TaskPlannerApplication taskPlannerApplication = null;


    private static Scanner scanner;
    private static UserService userService ;
    private static SprintService sprintService;
    private static TaskService taskService ;
    private static AppRepository appRepository;
    private TaskPlannerApplication(){
        // private constructor

    }
    public static TaskPlannerApplication getInstance(){
        if(taskPlannerApplication == null){
            taskPlannerApplication = new TaskPlannerApplication();
            scanner = new Scanner(System.in);
            userService = new UserService();
            sprintService = new SprintService();
            taskService = new TaskService();
            appRepository = new AppRepository();
        }
        return taskPlannerApplication;
    }


    public AppRepository getAppRepository() {
        return appRepository;
    }

    public  Scanner getScanner() {
        return scanner;
    }
    public UserService getUserService() {
        return userService;
    }

    public SprintService getSprintService() {
        return sprintService;
    }

    public TaskService getTaskService() {
        return taskService;
    }
    public void execute(){
        CliController cliController = new CliController();
        cliController.execute();
    }
}

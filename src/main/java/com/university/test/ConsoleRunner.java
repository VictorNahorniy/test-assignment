package com.university.test;

import com.university.test.controllers.UniversityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UniversityController universityController;

    @Autowired
    public ConsoleRunner(UniversityController universityController) {
        this.universityController = universityController;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            drawMenu();
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String result = "";
            switch (command) {
                case "1":
                    result = universityController.getHeadOfDepartment(getDepartmentNameByConsole());
                    break;
                case "2":
                    result = universityController.getDepartmentStatistic(getDepartmentNameByConsole());
                    break;
                case "3":
                    result = universityController.getDepartmentAvgSalary(getDepartmentNameByConsole());
                    break;
                case "4":
                    result = universityController.getDepartmentEmployeeCount(getDepartmentNameByConsole());
                    break;
                case "5":
                    result = universityController.getGlobalSearch(getTemplateByConsole());
                    break;
                case "6":
                    System.exit(0);
                    break;
                default:
                    result = "Invalid command";
            }
            System.out.println(result);
        }
    }

    private String getDepartmentNameByConsole() {
        System.out.println("Enter department name:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private String getTemplateByConsole() {
        System.out.println("Enter template:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private void drawMenu() {
        System.out.println();
        System.out.println("Welcome to the University database!");
        System.out.println("Please, enter your command:");
        System.out.println("1. Who is head of department {department_name}");
        System.out.println("2. Show {department_name} statistic");
        System.out.println("3. Show the average salary for department {department_name}");
        System.out.println("4. Show count of employee for {department_name}");
        System.out.println("5. Global search by {template}");
        System.out.println("6. Exit");
        System.out.println("Enter command:");
    }
}
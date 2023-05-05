package com.university.test;

import com.university.test.controllers.UniversityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestAssignmentApplication {
    static UniversityController universityController;

    @Autowired
    public TestAssignmentApplication(UniversityController universityController) {
        this.universityController = universityController;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestAssignmentApplication.class, args);
        ConsoleRunner consoleRunner = new ConsoleRunner(universityController);
        consoleRunner.run(args);
    }

}

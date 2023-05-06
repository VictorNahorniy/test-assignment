package com.university.test;

import com.university.test.controllers.UniversityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestAssignmentApplication {
    private static ConsoleRunner consoleRunner;

    @Autowired
    public TestAssignmentApplication(ConsoleRunner consoleRunner) {
        this.consoleRunner = consoleRunner;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestAssignmentApplication.class, args);
        consoleRunner.run(args);
    }

}

package com.university.test.controllers;

import com.university.test.service.DegreeService;
import com.university.test.service.DepartmentLectorService;
import com.university.test.service.DepartmentService;
import com.university.test.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UniversityController {
    private final DepartmentLectorService departmentLectorService;
    private final DegreeService degreeService;
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    @Autowired
    public UniversityController(DepartmentLectorService departmentLectorService,
                                DegreeService degreeService,
                                DepartmentService departmentService,
                                LectorService lectorService) {
        this.departmentLectorService = departmentLectorService;
        this.degreeService = degreeService;
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    @GetMapping("/headOfDepartment")
    public String getHeadOfDepartment(String departmentName) {
        return departmentService.getHeadOfDepartment(departmentName);
    }

    @GetMapping("/departmentAvgSalary")
    public String getDepartmentAvgSalary(String departmentName) {
        return departmentLectorService.getAverageSalary(departmentName);
    }

    @GetMapping("/departmentEmployeeCount")
    public String getDepartmentEmployeeCount(String departmentName) {
        return departmentLectorService.getEmployeeCount(departmentName);
    }

    @GetMapping("/departmentStatistic")
    public String getDepartmentStatistic(String departmentName) {
        return departmentLectorService.getDepartmentStatistic(departmentName);
    }

    @GetMapping("/globalSearch")
    public String getGlobalSearch(String template) {
        return "Result:\n"
                + lectorService.searchByTemplate(template) + "\n"
                + degreeService.searchByTemplate(template) + "\n"
                + departmentService.searchByTemplate(template);
    }
}

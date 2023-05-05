package com.university.test.service;

public interface DepartmentLectorService {
    String getDepartmentStatistic(String departmentName);

    String getAverageSalary(String departmentName);

    String getEmployeeCount(String departmentName);
}

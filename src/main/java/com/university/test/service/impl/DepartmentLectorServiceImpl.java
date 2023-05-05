package com.university.test.service.impl;

import com.university.test.repositories.DepartmentLectorRepository;
import com.university.test.repositories.DepartmentRepository;
import com.university.test.service.DepartmentLectorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentLectorServiceImpl implements DepartmentLectorService {
    private DepartmentLectorRepository departmentLectorRepository;
    private DepartmentRepository departmentRepository;
    private String errorMessage = "Sorry, department with this name does not exist.";

    @Autowired
    public DepartmentLectorServiceImpl(DepartmentLectorRepository departmentLectorRepository,
                                       DepartmentRepository departmentRepository) {
        this.departmentLectorRepository = departmentLectorRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String getDepartmentStatistic(String departmentName) {
        if (!departmentRepository.existsByName(departmentName)) {
            log.error("Department with name {} doesn't exist", departmentName);
            return errorMessage;
        }
        return "assistants - "
                + departmentLectorRepository.countAllByDepartmentNameAndDegree(departmentName, "assistant")
                + ", associate professors - "
                + departmentLectorRepository.countAllByDepartmentNameAndDegree(departmentName, "associate professor")
                + ", professors - "
                + departmentLectorRepository.countAllByDepartmentNameAndDegree(departmentName, "professor");
    }

    @Override
    public String getAverageSalary(String departmentName) {
        if (!departmentRepository.existsByName(departmentName)) {
            log.error("Department with name {} doesn't exist", departmentName);
            return errorMessage;
        }
        return "The average salary of " + departmentName + " is "+
                String.format("%.2f", departmentLectorRepository.findAverageSalary(departmentName));
    }

    @Override
    public String getEmployeeCount(String departmentName) {
        if (!departmentRepository.existsByName(departmentName)) {
            log.error("Department with name {} doesn't exist", departmentName);
            return errorMessage;
        }
        return departmentLectorRepository.countEmployeesByDepartmentName(departmentName).toString();
    }
}

package com.university.test.service.impl;

import com.university.test.repositories.DepartmentRepository;
import com.university.test.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String getHeadOfDepartment(String departmentName) {
        if (!departmentRepository.existsByName(departmentName)) {
            log.error("Department with name {} doesn't exist", departmentName);
            return "Sorry, department with this name does not exist.";
        }
        if (departmentRepository.findHeadOfDepartment(departmentName) == null) {
            log.error("Department with name {} doesn't have head", departmentName);
            return "Sorry, department with this name doesn't have head.";
        }
        return "Head of "
                + departmentName
                + " department is "
                + departmentRepository.findHeadOfDepartment(departmentName).getName();
    }

    @Override
    public String searchByTemplate(String template) {
        String searchResult = "Departments: ";
        if (departmentRepository.findDepartmentsByTemplate('%' + template + '%').isEmpty()) {
            searchResult += "not found.";
            return searchResult;
        }
        searchResult += departmentRepository.findDepartmentsByTemplate('%' + template + '%').toString();
        return searchResult;
    }
}

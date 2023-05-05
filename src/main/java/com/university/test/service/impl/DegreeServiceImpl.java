package com.university.test.service.impl;

import com.university.test.repositories.DegreeRepository;
import com.university.test.service.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DegreeServiceImpl implements DegreeService {
    DegreeRepository degreeRepository;

    @Autowired
    public DegreeServiceImpl(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    @Override
    public String searchByTemplate(String template) {
        String searchResult = "Degrees: ";
        if (degreeRepository.findNameByTemplate('%' + template + '%').isEmpty()) {
            searchResult += "not found.";
            return searchResult;
        }
        searchResult += degreeRepository.findNameByTemplate('%' + template + '%').toString();
        return searchResult;
    }
}

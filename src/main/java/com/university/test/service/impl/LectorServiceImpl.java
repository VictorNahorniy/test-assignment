package com.university.test.service.impl;

import com.university.test.repositories.LectorRepository;
import com.university.test.service.LectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LectorServiceImpl implements LectorService {
    LectorRepository lectorRepository;

    @Autowired
    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public String searchByTemplate(String template) {
        String searchResult = "Lectors: ";
        if (lectorRepository.findNameByTemplate('%' + template + '%').isEmpty()) {
            searchResult += "not found.";
            return searchResult;
        }
        searchResult += lectorRepository.findNameByTemplate('%' + template + '%').toString();
        return searchResult;
    }
}

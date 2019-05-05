package com.example.seedstarter.services;

import com.example.seedstarter.entities.Variety;
import com.example.seedstarter.entities.repositories.VarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VarietyService {

    @Autowired
    private VarietyRepository varietyRepository;

    public List<Variety> findAll() {
        List<Variety> varieties = new ArrayList<>();
        varietyRepository.findAll().forEach(varieties::add);
        return varieties;
    }

    public Variety findById(long id) {
        return varietyRepository.findById(id).get();
    }
}

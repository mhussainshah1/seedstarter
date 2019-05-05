package com.example.seedstarter.services;

import com.example.seedstarter.entities.SeedStarter;
import com.example.seedstarter.entities.repositories.SeedStarterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeedStarterService {

    @Autowired
    private SeedStarterRepository seedstarterRepository;

    public List<SeedStarter> findAll() {
        List<SeedStarter> seedStarter = new ArrayList<>();
        seedstarterRepository.findAll().forEach(seedStarter::add);
        return seedStarter;
    }

    public void add(SeedStarter seedStarter) {
        seedstarterRepository.save(seedStarter);
    }
}

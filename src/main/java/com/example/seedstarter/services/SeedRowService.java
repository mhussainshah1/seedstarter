package com.example.seedstarter.services;

import com.example.seedstarter.entities.SeedRow;
import com.example.seedstarter.entities.SeedStarter;
import com.example.seedstarter.entities.repositories.SeedRowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedRowService {

    @Autowired
    SeedRowRepository seedRowRepository;

    public void add(SeedRow seedRow) {
        seedRowRepository.save(seedRow);
    }

    public void addAll(List<SeedRow> seedRows, SeedStarter seedStarter) {
        for (SeedRow row : seedRows) {
            SeedRow seedRow =
                    new SeedRow(row.getSeedsPerCell(),
                            row.getVariety(),
                            seedStarter);
            seedRowRepository.save(seedRow);
        }
    }
}

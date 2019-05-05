package com.example.seedstarter;

import com.example.seedstarter.entities.*;
import com.example.seedstarter.entities.repositories.SeedRowRepository;
import com.example.seedstarter.entities.repositories.SeedStarterRepository;
import com.example.seedstarter.entities.repositories.VarietyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    SeedStarterRepository seedStarterRepository;

    @Autowired
    VarietyRepository varietyRepository;

    @Autowired
    SeedRowRepository seedRowRepository;

    @Override
    public void run(String... strings) throws Exception {

        SeedStarter seedStarter = new SeedStarter(LocalDate.now(), true, Type.PLASTIC, Feature.ALL);
        seedStarterRepository.save(seedStarter);

        varietyRepository.save(new Variety("Thymus vulgaris"));
        Variety variety1 = varietyRepository.findByName("Thymus vulgaris");

        varietyRepository.save(new Variety("Thymus x citriodorus"));
        Variety variety2 = varietyRepository.findByName("Thymus x citriodorus");

        varietyRepository.save(new Variety("Thymus herba-barona"));
        Variety variety3 = varietyRepository.findByName("Thymus herba-barona");

        varietyRepository.save(new Variety("Thymus pseudolaginosus"));
        Variety variety4 = varietyRepository.findByName("Thymus pseudolaginosus");

        varietyRepository.save(new Variety("Thymus serpyllum"));
        Variety variety5 = varietyRepository.findByName("Thymus serpyllum");

        Set<SeedRow> rows = new HashSet<>();
        rows.add(new SeedRow(10, variety1, seedStarter));
        rows.add(new SeedRow(20, variety2, seedStarter));
        seedRowRepository.saveAll(rows);
    }
}

package com.example.seedstarter.entities.repositories;

import com.example.seedstarter.entities.SeedStarter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeedStarterRepository extends CrudRepository<SeedStarter, Long> {
}

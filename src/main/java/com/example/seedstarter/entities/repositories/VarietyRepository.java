package com.example.seedstarter.entities.repositories;

import com.example.seedstarter.entities.Variety;
import org.springframework.data.repository.CrudRepository;

public interface VarietyRepository extends CrudRepository<Variety, Long> {
    Variety findByName(String name);
}

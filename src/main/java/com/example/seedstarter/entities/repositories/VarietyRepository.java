package com.example.seedstarter.entities.repositories;

import com.example.seedstarter.entities.Variety;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VarietyRepository extends CrudRepository<Variety, Long> {
    Variety findByName(String name);
}

package com.example.seedstarter.entities;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Variety {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "variety")
    private Set<SeedRow> seedRow;

    public Variety() {
        seedRow = new HashSet<>();
    }

    public Variety(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SeedRow> getSeedRow() {
        return seedRow;
    }

    public void setSeedRow(Set<SeedRow> seedRow) {
        this.seedRow = seedRow;
    }
}

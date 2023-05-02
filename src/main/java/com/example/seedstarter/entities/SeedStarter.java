package com.example.seedstarter.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SeedStarter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDate datePlanted;

    private boolean covered;

    @Enumerated(EnumType.STRING)
    private Type type;

    @ElementCollection
    @OrderColumn
    @Enumerated(EnumType.STRING)
    private Feature[] features;

    @OneToMany(mappedBy = "seedStarter")
    private List<SeedRow> seedRows;

    public SeedStarter() {
        datePlanted = LocalDate.now();
        seedRows = new ArrayList<>();
    }

    public SeedStarter(LocalDate datePlanted, boolean covered, Type type, Feature[] features) {
        this.datePlanted = datePlanted;
        this.covered = covered;
        this.type = type;
        this.features = features;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDatePlanted() {
        return datePlanted;
    }

    public void setDatePlanted(LocalDate datePlanted) {
        this.datePlanted = datePlanted;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Feature[] getFeatures() {
        return features;
    }

    public void setFeatures(Feature[] features) {
        this.features = features;
    }

    public List<SeedRow> getSeedRows() {
        return seedRows;
    }

    public void setSeedRows(List<SeedRow> seedRows) {
        this.seedRows = seedRows;
    }
}

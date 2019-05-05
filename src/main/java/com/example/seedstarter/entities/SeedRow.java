package com.example.seedstarter.entities;

import javax.persistence.*;

@Entity
public class SeedRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int seedsPerCell;

    @ManyToOne
    private Variety variety;

    @ManyToOne
    private SeedStarter seedStarter;

    public SeedRow() {
        variety = new Variety();
        seedStarter = new SeedStarter();
    }

    public SeedRow(int seedsPerCell, Variety variety, SeedStarter seedStarter) {
        this.seedsPerCell = seedsPerCell;
        this.variety = variety;
        this.seedStarter = seedStarter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSeedsPerCell() {
        return seedsPerCell;
    }

    public void setSeedsPerCell(int seedsPerCell) {
        this.seedsPerCell = seedsPerCell;
    }

    public Variety getVariety() {
        return variety;
    }

    public void setVariety(Variety variety) {
        this.variety = variety;
    }

    public SeedStarter getSeedStarter() {
        return seedStarter;
    }

    public void setSeedStarter(SeedStarter seedStarter) {
        this.seedStarter = seedStarter;
    }

}

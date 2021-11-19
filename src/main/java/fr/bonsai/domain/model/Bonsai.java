package fr.bonsai.domain.model;

import java.util.UUID;

public class Bonsai {


    private UUID id;


    private String name;

    public Bonsai(){

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

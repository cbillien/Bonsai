package fr.commons;


import fr.bonsai.domain.Pruning;
import fr.bonsai.domain.Repotting;
import fr.bonsai.domain.Watering;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(name = "bonsai")
@Table(name = "bonsai")
public class BonsaiEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "species")
    private String species;
    @Column(name = "acquisition_date")
    private Date acquisition_date;
    @Column(name = "acquisition_age")
    private int acquisition_age;
    @Column(name = "status")
    private String status;




    @OneToMany(targetEntity = PruningEntity.class)
    private List<PruningEntity> listPruning;

    @OneToMany(targetEntity = RepottingEntity.class)
    private List<RepottingEntity> listRepotting;

    @OneToMany(targetEntity = WateringEntity.class)
    private List<WateringEntity> listWatering;

    public BonsaiEntity() {
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Date getAcquisition_date() {
        return acquisition_date;
    }

    public void setAcquisition_date(Date acquisition_date) {
        this.acquisition_date = acquisition_date;
    }

    public int getAcquisition_age() {
        return acquisition_age;
    }

    public void setAcquisition_age(int acquisition_age) {
        this.acquisition_age = acquisition_age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public List<PruningEntity> getListPruning() {
        return listPruning;
    }

    public void setListPruning(List<PruningEntity> listPruning) {
        this.listPruning = listPruning;
    }

    public List<RepottingEntity> getListRepotting() {
        return listRepotting;
    }

    public void setListRepotting(List<RepottingEntity> listRepotting) {
        this.listRepotting = listRepotting;
    }

    public List<WateringEntity> getListWatering() {
        return listWatering;
    }

    public void setListWatering(List<WateringEntity> listWatering) {
        this.listWatering = listWatering;
    }
}

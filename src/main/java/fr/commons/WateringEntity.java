package fr.commons;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "watering")
@Table(name = "watering")
public class WateringEntity {



    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "watering_date")
    private Date watering_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bonsai_id")
    private BonsaiEntity bonsai;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getWatering_date() {
        return watering_date;
    }

    public void setWatering_date(Date watering_date) {
        this.watering_date = watering_date;
    }

    public BonsaiEntity getBonsai() {
        return bonsai;
    }

    public void setBonsai(BonsaiEntity bonsai) {
        this.bonsai = bonsai;
    }
}
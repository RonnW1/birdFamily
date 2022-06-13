package com.co.ias.birdFamily.birds.application.domain;

import com.co.ias.birdFamily.birds.application.domain.valueObjs.*;

public class BirdFamily {
    private final BirdFamilyId id;
    private final BirdFamilyName name;
    private final BirdScientificName scientificName;
    private final BirdZoneName zoneName;
    private final BirdConfirmedQuantity quantity;

    public BirdFamily(BirdFamilyId id, BirdFamilyName name, BirdScientificName scientificName, BirdZoneName zoneName, BirdConfirmedQuantity quantity) {
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
        this.zoneName = zoneName;
        this.quantity = quantity;
    }

    public BirdFamilyId getId() {
        return id;
    }

    public BirdFamilyName getName() {
        return name;
    }

    public BirdScientificName getScientificName() {
        return scientificName;
    }

    public BirdZoneName getZoneName() {
        return zoneName;
    }

    public BirdConfirmedQuantity getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "BirdFamily{" +
                "id=" + id +
                ", name=" + name +
                ", scientificName=" + scientificName +
                ", zoneName=" + zoneName +
                ", quantity=" + quantity +
                '}';
    }
}

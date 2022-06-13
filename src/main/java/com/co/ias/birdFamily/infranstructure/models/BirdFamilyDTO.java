package com.co.ias.birdFamily.infranstructure.models;

import com.co.ias.birdFamily.birds.application.domain.BirdFamily;
import com.co.ias.birdFamily.birds.application.domain.valueObjs.*;

public class BirdFamilyDTO {
    private Long  id;
    private String name;
    private String scientificName;
    private String zoneName;
    private Integer quantity;
    private String status;

    public BirdFamilyDTO(Long id, String name, String scientificName, String zoneName, Integer quantity) {
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
        this.zoneName = zoneName;
        this.quantity = quantity;
    }

    public BirdFamilyDTO() {
    }

    public BirdFamily toDomian(){
        return new BirdFamily(
                new BirdFamilyId(id),
                new BirdFamilyName(name),
                new BirdScientificName(scientificName),
                new BirdZoneName(zoneName),
                new BirdConfirmedQuantity(quantity)
        );
    }

    public static BirdFamilyDTO fromDomian(BirdFamily birdFamily){
        BirdFamilyDTO birdFamilyDTO = new BirdFamilyDTO();
        birdFamilyDTO.setId(birdFamily.getId().getValue());
        birdFamilyDTO.setName(birdFamily.getName().getValue());
        birdFamilyDTO.setScientificName(birdFamily.getScientificName().getValue());
        birdFamilyDTO.setZoneName(birdFamily.getZoneName().getValue());
        birdFamilyDTO.setQuantity(birdFamily.getQuantity().getValue());
        return birdFamilyDTO;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScientificName() {
        return scientificName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BirdFamilyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", zoneName='" + zoneName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}

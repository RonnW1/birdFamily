package com.co.ias.birdFamily.infranstructure.models;

import com.co.ias.birdFamily.birds.application.domain.BirdFamily;
import com.co.ias.birdFamily.birds.application.domain.valueObjs.*;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class BirdFamilyDAO {
    private Long  id;
    private String name;
    private String scientificName;
    private String zoneName;
    private Integer quantity;

    public BirdFamilyDAO(Long id, String name, String scientificName, String zoneName, Integer quantity) {
        this.id = id;
        this.name = name;
        this.scientificName = scientificName;
        this.zoneName = zoneName;
        this.quantity = quantity;
    }

    public BirdFamilyDAO() {
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

    public static BirdFamilyDAO fromDomian(BirdFamily birdFamily){
        return new BirdFamilyDAO(
                birdFamily.getId().getValue(),
                birdFamily.getName().getValue(),
                birdFamily.getScientificName().getValue(),
                birdFamily.getZoneName().getValue(),
                birdFamily.getQuantity().getValue()
        );
    }

    public static BirdFamilyDAO fromResultSet(ResultSet resultSet) throws SQLException {
        BirdFamilyDAO birdFamilyDAO = new BirdFamilyDAO();
        birdFamilyDAO.setId(resultSet.getLong("id"));
        birdFamilyDAO.setName(resultSet.getString("name"));
        birdFamilyDAO.setScientificName(resultSet.getString("scientificName"));
        birdFamilyDAO.setZoneName(resultSet.getString("zoneName"));
        birdFamilyDAO.setQuantity(resultSet.getInt("quantity"));

        return birdFamilyDAO;
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
}

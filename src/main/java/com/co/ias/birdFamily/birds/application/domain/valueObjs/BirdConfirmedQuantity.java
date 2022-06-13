package com.co.ias.birdFamily.birds.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdConfirmedQuantity {
    private final Integer value;

    public BirdConfirmedQuantity(Integer value) {
        Validate.inclusiveBetween(1,100000, value, "The confirmed number of birds must be between 1 - 100000");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

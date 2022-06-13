package com.co.ias.birdFamily.birds.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdZoneName {
    private final String value;

    public BirdZoneName(String value) {
        Validate.notNull(value, "Bird Zone Name can not be null");
        Validate.isTrue(value.length() <= 20,"Bird Zone Name can not be longer than 20 characters");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}

package com.co.ias.birdFamily.birds.application.domain.valueObjs;

import org.apache.commons.lang3.Validate;

public class BirdFamilyName {
    private final String value;

    public BirdFamilyName(String value) {
        Validate.notNull(value, "Bird Family Name can not be null");
        Validate.isTrue(value.length() <= 30,"Bird Family name can not be longer than 30 characters");
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

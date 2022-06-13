package com.co.ias.birdFamily.birds.application.domain.valueObjs;

public class BirdFamilyId {
    private final Long value;

    public BirdFamilyId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}

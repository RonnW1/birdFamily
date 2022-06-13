package com.co.ias.birdFamily.ports.ouput;

import com.co.ias.birdFamily.birds.application.domain.BirdFamily;
import com.co.ias.birdFamily.birds.application.domain.valueObjs.BirdFamilyId;

import java.util.Optional;

public interface BirdFamilyRepository {
    void store(BirdFamily birdFamily);

    Optional<BirdFamily> get(BirdFamilyId birdFamilyId);

    void update(BirdFamily birdFamily);

    Boolean delete(BirdFamilyId birdFamilyId);
}

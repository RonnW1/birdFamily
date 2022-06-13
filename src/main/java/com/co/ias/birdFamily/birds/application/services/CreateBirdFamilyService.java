package com.co.ias.birdFamily.birds.application.services;

import com.co.ias.birdFamily.birds.application.domain.BirdFamily;
import com.co.ias.birdFamily.birds.application.domain.valueObjs.*;
import com.co.ias.birdFamily.ports.input.CreateBirdFamilyUseCase;
import com.co.ias.birdFamily.ports.ouput.BirdFamilyRepository;
import com.co.ias.birdFamily.infranstructure.models.BirdFamilyDTO;
import org.springframework.stereotype.Service;

@Service
public class CreateBirdFamilyService implements CreateBirdFamilyUseCase {
    private final BirdFamilyRepository birdFamilyRepository;

    public CreateBirdFamilyService(BirdFamilyRepository birdFamilyRepository) {
        this.birdFamilyRepository = birdFamilyRepository;
    }

    @Override
    public BirdFamilyDTO execute(BirdFamilyDTO birdFamilyDTO) {
        BirdFamily birdFamily = new BirdFamily(
                new BirdFamilyId(null),
                new BirdFamilyName(birdFamilyDTO.getName()),
                new BirdScientificName(birdFamilyDTO.getScientificName()),
                new BirdZoneName(birdFamilyDTO.getZoneName()),
                new BirdConfirmedQuantity(birdFamilyDTO.getQuantity())
        );
        birdFamilyRepository.store(birdFamily);
        birdFamilyDTO.setStatus("Created");
        return birdFamilyDTO;
    }
}

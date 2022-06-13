package com.co.ias.birdFamily.birds.application.services;

import com.co.ias.birdFamily.birds.application.domain.BirdFamily;
import com.co.ias.birdFamily.ports.input.UpdateBirdFamilyUseCase;
import com.co.ias.birdFamily.ports.ouput.BirdFamilyRepository;
import com.co.ias.birdFamily.infranstructure.models.BirdFamilyDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateBirdFamilyService implements UpdateBirdFamilyUseCase {
    private final BirdFamilyRepository birdFamilyRepository;

    public UpdateBirdFamilyService(BirdFamilyRepository birdFamilyRepository) {
        this.birdFamilyRepository = birdFamilyRepository;
    }

    @Override
    public BirdFamilyDTO execute(BirdFamilyDTO birdFamilyDTO) {
        BirdFamily birdFamily = birdFamilyDTO.toDomian();

        Optional<BirdFamily> birdFamilyBD =birdFamilyRepository.get(birdFamily.getId());

        if (birdFamilyBD.isPresent()){
            birdFamilyRepository.update(birdFamily);
            birdFamilyDTO.setStatus("Update");
        }else {
            birdFamilyDTO.setStatus("No Update");
        }
        return birdFamilyDTO;
    }
}

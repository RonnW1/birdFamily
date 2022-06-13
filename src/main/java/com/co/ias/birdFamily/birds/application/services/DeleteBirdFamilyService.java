package com.co.ias.birdFamily.birds.application.services;

import com.co.ias.birdFamily.birds.application.domain.BirdFamily;
import com.co.ias.birdFamily.birds.application.domain.valueObjs.BirdFamilyId;
import com.co.ias.birdFamily.ports.input.DeleteBirdFamilyUseCase;
import com.co.ias.birdFamily.ports.ouput.BirdFamilyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteBirdFamilyService implements DeleteBirdFamilyUseCase {
    private final BirdFamilyRepository birdFamilyRepository;

    public DeleteBirdFamilyService(BirdFamilyRepository birdFamilyRepository) {
        this.birdFamilyRepository = birdFamilyRepository;
    }

    @Override
    public Boolean execute(Long id) {
        BirdFamilyId birdFamilyId = new BirdFamilyId(id);

        Optional<BirdFamily> birdFamily = birdFamilyRepository.get(birdFamilyId);

        if (birdFamily.isPresent()){
            birdFamilyRepository.delete(birdFamilyId);
        }
        return birdFamily.isPresent();
    }
}

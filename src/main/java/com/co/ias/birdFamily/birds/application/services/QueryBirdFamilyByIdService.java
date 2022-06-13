package com.co.ias.birdFamily.birds.application.services;

import com.co.ias.birdFamily.birds.application.domain.BirdFamily;
import com.co.ias.birdFamily.birds.application.domain.valueObjs.BirdFamilyId;
import com.co.ias.birdFamily.ports.input.QueryBirdFamilyByIdUseCase;
import com.co.ias.birdFamily.ports.ouput.BirdFamilyRepository;
import com.co.ias.birdFamily.infranstructure.models.BirdFamilyDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryBirdFamilyByIdService implements QueryBirdFamilyByIdUseCase {
    private final BirdFamilyRepository birdFamilyRepository;

    public QueryBirdFamilyByIdService(BirdFamilyRepository birdFamilyRepository) {
        this.birdFamilyRepository = birdFamilyRepository;
    }

    @Override
    public Optional<BirdFamilyDTO> execute(Long id) {
        BirdFamilyId birdFamilyId = new BirdFamilyId(id);

        Optional<BirdFamily> birdFamily = birdFamilyRepository.get(birdFamilyId);

        return birdFamily.map(bird -> {
            BirdFamilyDTO birdFamilyDTO = BirdFamilyDTO.fromDomian(bird);
            return birdFamilyDTO;
        });
    }
}

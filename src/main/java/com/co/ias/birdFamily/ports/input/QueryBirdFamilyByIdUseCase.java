package com.co.ias.birdFamily.ports.input;

import com.co.ias.birdFamily.commons.UseCase;
import com.co.ias.birdFamily.infranstructure.models.BirdFamilyDTO;

import java.util.Optional;

public interface QueryBirdFamilyByIdUseCase extends UseCase<Long, Optional<BirdFamilyDTO>> {
}

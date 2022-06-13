package com.co.ias.birdFamily.infranstructure.controllers;

import com.co.ias.birdFamily.ports.input.CreateBirdFamilyUseCase;
import com.co.ias.birdFamily.ports.input.DeleteBirdFamilyUseCase;
import com.co.ias.birdFamily.ports.input.QueryBirdFamilyByIdUseCase;
import com.co.ias.birdFamily.ports.input.UpdateBirdFamilyUseCase;
import com.co.ias.birdFamily.infranstructure.models.ApplicationError;
import com.co.ias.birdFamily.infranstructure.models.BirdFamilyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class BirdFamilyController {
    private final CreateBirdFamilyUseCase createBirdFamilyUseCase;
    private final DeleteBirdFamilyUseCase deleteBirdFamilyUseCase;
    private final QueryBirdFamilyByIdUseCase queryBirdFamilyByIdUseCase;
    private final UpdateBirdFamilyUseCase updateBirdFamilyUseCase;

    public BirdFamilyController(CreateBirdFamilyUseCase createBirdFamilyUseCase, DeleteBirdFamilyUseCase deleteBirdFamilyUseCase, QueryBirdFamilyByIdUseCase queryBirdFamilyByIdUseCase, UpdateBirdFamilyUseCase updateBirdFamilyUseCase) {
        this.createBirdFamilyUseCase = createBirdFamilyUseCase;
        this.deleteBirdFamilyUseCase = deleteBirdFamilyUseCase;
        this.queryBirdFamilyByIdUseCase = queryBirdFamilyByIdUseCase;
        this.updateBirdFamilyUseCase = updateBirdFamilyUseCase;
    }

    @RequestMapping(value = "/birdsfamilies", method = RequestMethod.POST)
    public ResponseEntity<?> createBirdFamily(@RequestBody BirdFamilyDTO birdFamilyDTO){
        try {
            BirdFamilyDTO birdFamilyDTOoutput =createBirdFamilyUseCase.execute(birdFamilyDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(birdFamilyDTOoutput);
        }catch (NullPointerException | IllegalArgumentException e){
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data",
                    Map.of("error", e.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        }catch (Exception e){
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            System.out.println("Error......: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value = "/birdfamily/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> GetBirdFamily(@PathVariable("id") Long id){
        try {
            Optional<BirdFamilyDTO> birdFamilyDTO =queryBirdFamilyByIdUseCase.execute(id);
            if (birdFamilyDTO.isPresent()){
                return ResponseEntity.ok(birdFamilyDTO.get());
            }else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No exist bird family with this id");
            }
        }catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value = "/birdfamily", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateBirdFamily(@RequestBody BirdFamilyDTO birdFamilyDTO){
        try {
            BirdFamilyDTO birdFamilyDTO1 = updateBirdFamilyUseCase.execute(birdFamilyDTO);
            return ResponseEntity.ok(birdFamilyDTO1);
        }catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value ="/birdfamily/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> DeletebirdFamily(@PathVariable("id") Long id){
        try {
            Boolean result = deleteBirdFamilyUseCase.execute(id);
            if (result){
                return ResponseEntity.ok("Deleted");
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bird family can not be deleted");
            }
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InpuDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }
}

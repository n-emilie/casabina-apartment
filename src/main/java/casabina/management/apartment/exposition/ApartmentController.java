package casabina.management.apartment.exposition;

import casabina.management.apartment.application.DTO.ApartmentCreationDTO;
import casabina.management.apartment.application.DTO.ApartmentIdentityDTO;
import casabina.management.apartment.application.service.ApartmentService;
import casabina.management.apartment.application.service.ApartmentServiceImpl;
import casabina.management.apartment.domain.model.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentController {

    private ApartmentServiceImpl apartmentService;

    @Autowired
    public ApartmentController(ApartmentServiceImpl apartmentService) {
        this.apartmentService = apartmentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApartmentById(@PathVariable Long id){
        try {
            ApartmentIdentityDTO apartmentIdentityDTO = apartmentService.getApartmentById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(apartmentIdentityDTO);
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<?> getAllApartments(){
        try{
            List<ApartmentIdentityDTO> apartments = apartmentService.getAllApartments();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(apartments);
        }catch(Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<?> createApartment(@RequestBody ApartmentCreationDTO apartmentDTO){
        try{
            ApartmentIdentityDTO saved = apartmentService.createApartment(apartmentDTO);

            return ResponseEntity
                    .status(HttpStatus.CREATED) // Retourne 201 Created
                    .body(Map.of(
                            "message", "Appartement créé avec succès",
                            "apartment", saved
                    ));
        }catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public void deleteApartment(@PathVariable Long id){
        apartmentService.deleteApartment(id);
    }

}

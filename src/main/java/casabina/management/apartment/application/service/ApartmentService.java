package casabina.management.apartment.application.service;

import casabina.management.apartment.application.DTO.ApartmentCreationDTO;
import casabina.management.apartment.application.DTO.ApartmentIdentityDTO;
import casabina.management.apartment.domain.model.Apartment;

import java.util.List;
import java.util.Optional;

public interface ApartmentService {
    List<ApartmentIdentityDTO> getAllApartments();
    ApartmentIdentityDTO getApartmentById(Long id);
    ApartmentIdentityDTO createApartment(ApartmentCreationDTO apartment);
    void deleteApartment(Long id);
}

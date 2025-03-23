package casabina.management.apartment.application.service;

import casabina.management.apartment.application.DTO.ApartmentCreationDTO;
import casabina.management.apartment.application.DTO.ApartmentIdentityDTO;
import casabina.management.apartment.application.mapper.ApartmentMapper;
import casabina.management.apartment.domain.model.Apartment;
import casabina.management.apartment.domain.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ApartmentServiceImpl implements ApartmentService{
    private final ApartmentRepository apartmentRepository;
    private final ApartmentMapper apartmentMapper;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
        this.apartmentMapper = ApartmentMapper.INSTANCE;
    }

    @Override
    public ApartmentIdentityDTO getApartmentById(Long id) {
        return apartmentRepository.findById(id)
                .map(apartmentMapper::toApartmentIdentityDTO)
                .orElseThrow(NullPointerException::new);
    }

    @Override
    public List<ApartmentIdentityDTO> getAllApartments() {
        return apartmentRepository.findAll()
                .stream()
                .map(apartmentMapper::toApartmentIdentityDTO)
                .toList();

    }

    @Override
    public ApartmentIdentityDTO createApartment(ApartmentCreationDTO apartmentDTO) {
        Apartment apartment = new Apartment(apartmentDTO.name(),apartmentDTO.capacity());
        var saved = apartmentRepository.save(apartment);
        return apartmentMapper.toApartmentIdentityDTO(saved);

    }

    @Override
    public void deleteApartment(Long id) {
        apartmentRepository.deleteById(id);
    }
}

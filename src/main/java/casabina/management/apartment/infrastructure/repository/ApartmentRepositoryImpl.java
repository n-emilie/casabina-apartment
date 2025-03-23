package casabina.management.apartment.infrastructure.repository;

import casabina.management.apartment.domain.model.Apartment;
import casabina.management.apartment.domain.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ApartmentRepositoryImpl implements ApartmentRepository {
    private final ApartmentDAO apartmentDAO;

    @Autowired
    public ApartmentRepositoryImpl(ApartmentDAO apartmentDAO) {
        this.apartmentDAO = apartmentDAO;
    }

    @Override
    public List<Apartment> findAll() {
        return apartmentDAO.findAll();
    }

    @Override
    public Optional<Apartment> findById(Long id) {
        return apartmentDAO.findById(id);
    }

    @Override
    public Apartment save(Apartment apartment) {
        return apartmentDAO.save(apartment);
    }

    @Override
    public void deleteById(Long id) {
        apartmentDAO.deleteById(id);
    }
}

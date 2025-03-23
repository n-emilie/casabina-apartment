package casabina.management.apartment.infrastructure.repository;

import casabina.management.apartment.domain.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentDAO extends JpaRepository<Apartment, Long>{
}

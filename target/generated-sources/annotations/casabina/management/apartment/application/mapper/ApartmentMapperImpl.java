package casabina.management.apartment.application.mapper;

import casabina.management.apartment.application.DTO.ApartmentIdentityDTO;
import casabina.management.apartment.domain.model.Apartment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-23T02:04:06+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class ApartmentMapperImpl implements ApartmentMapper {

    @Override
    public ApartmentIdentityDTO toApartmentIdentityDTO(Apartment apartment) {
        if ( apartment == null ) {
            return null;
        }

        String name = null;
        int capacity = 0;

        name = apartment.getName();
        capacity = apartment.getCapacity();

        ApartmentIdentityDTO apartmentIdentityDTO = new ApartmentIdentityDTO( name, capacity );

        return apartmentIdentityDTO;
    }
}

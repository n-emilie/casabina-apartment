package casabina.management.apartment.application.mapper;

import casabina.management.apartment.application.DTO.ApartmentIdentityDTO;
import casabina.management.apartment.domain.model.Apartment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApartmentMapper {
    ApartmentMapper INSTANCE = Mappers.getMapper(ApartmentMapper.class);
    ApartmentIdentityDTO toApartmentIdentityDTO(Apartment apartment);
}


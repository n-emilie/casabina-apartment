package casabina.management.apartment.application.DTO;

public record ApartmentCreationDTO(
        String name,
        int capacity) {

    public ApartmentCreationDTO{
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom de l'appartement est obligatoire");
        }
        if (capacity < 1) {
            throw new IllegalArgumentException("La capacité doit être d'au moins 1");
        }
    }


}
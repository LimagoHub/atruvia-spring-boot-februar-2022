package de.bankenit.webapp.restcontrollers.mappers;

import org.mapstruct.Mapper;

import de.bankenit.webapp.restcontrollers.dtos.SchweinDTO;
import de.bankenit.webapp.services.model.Schwein;

@Mapper(componentModel = "spring")
public interface SchweinDTOMapper {
    public Schwein convert(SchweinDTO dto);
    public SchweinDTO convert(Schwein schwein);
    public Iterable<SchweinDTO> convert(Iterable<Schwein> schweine);
}

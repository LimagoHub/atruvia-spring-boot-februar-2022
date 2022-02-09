package de.bankenit.webapp.services.mappers;

import org.mapstruct.Mapper;

import de.bankenit.webapp.repositories.entity.SchweinEntity;
import de.bankenit.webapp.services.model.Schwein;

@Mapper(componentModel = "spring")
public interface SchweinMapper {

	Schwein convert(SchweinEntity entity);
	SchweinEntity convert(Schwein schwein);
	Iterable<Schwein> convert(Iterable<SchweinEntity> entities);
}

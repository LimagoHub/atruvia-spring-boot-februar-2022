package de.bankenit.webapp.services.mappers;

import org.mapstruct.Mapper;

import de.bankenit.webapp.repositories.entity.PersonEntity;
import de.bankenit.webapp.services.model.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	
	Person convert(PersonEntity entity);
	PersonEntity convert(Person person);
	Iterable<Person> convert(Iterable<PersonEntity> entities);
}

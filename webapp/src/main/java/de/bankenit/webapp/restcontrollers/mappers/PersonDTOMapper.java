package de.bankenit.webapp.restcontrollers.mappers;

import org.mapstruct.Mapper;

import de.bankenit.webapp.restcontrollers.dtos.PersonDTO;
import de.bankenit.webapp.services.model.Person;

@Mapper(componentModel = "spring")
public interface PersonDTOMapper {
	
	PersonDTO convert(Person person);
	Person convert(PersonDTO dto);
	Iterable<PersonDTO> convert(Iterable<Person> personen);
}

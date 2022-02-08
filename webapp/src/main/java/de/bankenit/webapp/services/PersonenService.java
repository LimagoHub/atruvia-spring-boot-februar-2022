package de.bankenit.webapp.services;

import java.util.Optional;

import de.bankenit.webapp.repositories.entity.TinyPerson;
import de.bankenit.webapp.services.model.Person;

public interface PersonenService {
	
	boolean speichernOderEinfuegen(Person person) throws PersonenServiceException;
	boolean loeschen(Person person) throws PersonenServiceException;
	boolean loeschen(String id) throws PersonenServiceException;
	Optional<Person> findeNachId(String id) throws PersonenServiceException;
	Iterable<Person> findeAlle() throws PersonenServiceException;
	Iterable<TinyPerson> findeAlleTinies() throws PersonenServiceException;
}

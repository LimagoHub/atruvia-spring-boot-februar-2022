package de.bankenit.webapp.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.bankenit.webapp.repositories.PersonenRepository;
import de.bankenit.webapp.repositories.entity.TinyPerson;
import de.bankenit.webapp.services.PersonenService;
import de.bankenit.webapp.services.PersonenServiceException;
import de.bankenit.webapp.services.mappers.PersonMapper;
import de.bankenit.webapp.services.model.Person;

@Service
@Transactional(rollbackFor = PersonenServiceException.class, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class PersonenServiceImpl implements PersonenService {

	private final PersonenRepository repo;
	private final PersonMapper mapper;
	private final List<String> antipathen;
	
	
	

	public PersonenServiceImpl(PersonenRepository repo, PersonMapper mapper, @Qualifier("antipathen") List<String> antipathen) {
		super();
		this.repo = repo;
		this.mapper = mapper;
		this.antipathen = antipathen;
	}
	
	

	@Override
	public boolean speichernOderEinfuegen(Person person) throws PersonenServiceException {
		try {
			return speichernImpl(person);
		} catch (RuntimeException e) {
			// Log
			throw new PersonenServiceException("Fehler im Service", e);
		}
	}

	private boolean speichernImpl(Person person) throws PersonenServiceException {
		if(person == null)
			throw new PersonenServiceException("Person darf nicht null sein");
		
		if(person.getVorname() == null || person.getVorname().length() < 2)
			throw new PersonenServiceException("Vorname zu kurz");
		
		
		if(person.getNachname() == null || person.getNachname().length() < 2)
			throw new PersonenServiceException("Nachname zu kurz");
		
		if(antipathen.contains(person.getVorname()))
			throw new PersonenServiceException("Unsympath");
		
		boolean result = repo.existsById(person.getId());
		
		repo.save(mapper.convert(person));

		
		return result;
	}



	@Override
	public boolean loeschen(Person person) throws PersonenServiceException {
		
		return loeschen(person.getId());
	}



	@Override
	public boolean loeschen(String id) throws PersonenServiceException {
		try {
			if( repo.existsById(id)) {
				repo.deleteById(id);
				return true;
			}
			return false;
		} catch (RuntimeException e) {
			// Log
			throw new PersonenServiceException("Fehler im Service", e);
		}
	}



	@Override
	public Optional<Person> findeNachId(String id) throws PersonenServiceException {
		try {
			return repo.findById(id).map(mapper::convert);
		} catch (RuntimeException e) {
			// Log
			throw new PersonenServiceException("Fehler im Service", e);
		}
	}



	@Override
	public Iterable<Person> findeAlle() throws PersonenServiceException {
		try {
			return mapper.convert(repo.findAll());
		} catch (RuntimeException e) {
			// Log
			throw new PersonenServiceException("Fehler im Service", e);
		}
	}



	@Override
	public Iterable<TinyPerson> findeAlleTinies() throws PersonenServiceException {
		try {
			return repo.findAllTinyPersons();
		} catch (RuntimeException e) {
			// Log
			throw new PersonenServiceException("Fehler im Service", e);
		}
	}

}

package de.bankenit.dbdemo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.bankenit.dbdemo.repos.PersonenRepository;
import de.bankenit.dbdemo.repos.entities.Kontakt;
import de.bankenit.dbdemo.repos.entities.PersonEntity;
import lombok.AllArgsConstructor;

//@Component
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED)
public class DbDemo {

	private final PersonenRepository repo;
	
	public PersonEntity save() {
		PersonEntity p = PersonEntity
				.builder()
				.id(UUID.randomUUID().toString())
				.vorname("Max")
				.nachname("M")
				
				.build();
		
		// p ist Transient (DB nicht bekannt (persistiert))
		
		PersonEntity pNeu = repo.save(p);
		
		// pNeu wird persistiert (p ist persistent)
		// pNeu wird zusätzlich attached
		
		// pNeu.setNachname("Mustermann");
	
		Kontakt k1 = new Kontakt("Telefon","12345");
		Kontakt k2 = new Kontakt("Mobil","54321");
		
		pNeu.getKontakte().add(k1);
		pNeu.getKontakte().add(k2);
		
		return pNeu;
	}
	
	public PersonEntity findDemo() {
		Optional<PersonEntity> optional = repo.findById("70acb02e-d0f8-4f2c-976e-923edbcbd9d3");
		if(optional.isPresent()) {
			PersonEntity p = optional.get();
			p.setVorname("Erika");
			//p.getKontakte().get(0).setWert("4711");
			return p;
		}
		return null;
	}
	
	
	public void renameAll() {
		List<PersonEntity> collect = Streamable.of(repo.findAll()).stream().collect(Collectors.toList());
		for (PersonEntity personEntity : collect) {
			personEntity.setNachname("Doe");
		}
	}
}

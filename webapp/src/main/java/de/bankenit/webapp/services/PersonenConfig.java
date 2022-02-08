package de.bankenit.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.bankenit.webapp.repositories.PersonenRepository;
import de.bankenit.webapp.services.impl.PersonenServiceImpl;
import de.bankenit.webapp.services.mappers.PersonMapper;

@Configuration
public class PersonenConfig {

	@Bean
	@Qualifier("antipathen")
	public List<String> antipathen() {
		return List.of("Attila","Peter","Paul","Mary");
	}
	
	@Bean
	@Qualifier("fruits")
	public List<String> fruits() {
		return List.of("Apple","cherry","Strawberry","Raspberry");
	}


//	@Bean
//	
//	public PersonenService getPersonenService(PersonenRepository repo, PersonMapper mapper, @Qualifier("antipathen") List<String> antipathen) {
//		return new PersonenServiceImpl(repo, mapper, antipathen);
//	}
}

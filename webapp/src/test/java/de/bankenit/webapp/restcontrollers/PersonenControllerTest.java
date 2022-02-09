package de.bankenit.webapp.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import de.bankenit.webapp.restcontrollers.dtos.PersonDTO;
import de.bankenit.webapp.services.PersonenService;
import de.bankenit.webapp.services.model.Person;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@Sql({"create.sql", "insert.sql"})
@ExtendWith(SpringExtension.class)
public class PersonenControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	 @MockBean
	 private PersonenService serviceMock;
	
	@Test
	void test1() throws Exception {
		
		Optional<Person> optionalPerson = Optional.of(Person.builder().id("1").vorname("John").nachname("Doe").build());
		
		when(serviceMock.findeNachId(anyString())).thenReturn(optionalPerson);
		
		PersonDTO personDTO = restTemplate.getForObject("/v1/personen/b2e24e74-8686-43ea-baff-d9396b4202e0", PersonDTO.class);
		
		assertEquals("John",personDTO.getVorname());
	}

//	@Test
//	void test2() throws Exception {
//		String personDTO = restTemplate.getForObject("/v1/personen/b2e24e74-8686-43ea-baff-d9396b4202e0", String.class);
//		
//		System.out.println(personDTO);
//	}
	
	@Test
	void test3() throws Exception {
		
		Optional<Person> optionalPerson = Optional.of(Person.builder().id("1").vorname("John").nachname("Doe").build());
		
		when(serviceMock.findeNachId(anyString())).thenReturn(optionalPerson);
		
		ResponseEntity<PersonDTO> entity = restTemplate.getForEntity("/v1/personen/b2e24e74-8686-43ea-baff-d9396b4202e0", PersonDTO.class);
		
		PersonDTO personDTO = entity.getBody();
		
		assertEquals("John",personDTO.getVorname());
		assertEquals(HttpStatus.OK,entity.getStatusCode());
	}


}

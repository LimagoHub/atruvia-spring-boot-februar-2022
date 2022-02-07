package de.bankenit.webapp.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.bankenit.webapp.restcontrollers.dtos.PersonDTO;

@RestController
@RequestMapping("/v1/demo")
public class DemoController {
	
	
	private final List<PersonDTO> personen = List.of(
			PersonDTO.builder().id("1").vorname("John").nachname("Doe").build(),
			PersonDTO.builder().id("2").vorname("John").nachname("Rambo").build(),
			PersonDTO.builder().id("3").vorname("John").nachname("McClain").build(),
			PersonDTO.builder().id("4").vorname("John").nachname("Wick").build()
	);

	@GetMapping("/gruss")
	public String fritz() {
		return "Hallo Welt!";
	}

	@GetMapping(path = "/person", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<PersonDTO> getPerson() {
		PersonDTO result =  PersonDTO.builder().id("1").vorname("John").nachname("Doe").build();
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(path = "/personen/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PersonDTO> getPersonByID(@PathVariable String id) {
		Optional<PersonDTO> myOptional = personen.stream().filter(p->p.getId().equals(id)).findFirst();
		return ResponseEntity.of(myOptional);
	}
}

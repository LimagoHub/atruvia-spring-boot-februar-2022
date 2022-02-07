package de.bankenit.webapp.restcontrollers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.glassfish.jersey.uri.UriComponent;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import de.bankenit.webapp.restcontrollers.dtos.PersonDTO;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/personen")
@Slf4j
public class PersonenController {

	private final List<PersonDTO> personen = List.of(
			PersonDTO.builder().id("1").vorname("John").nachname("Doe").build(),
			PersonDTO.builder().id("2").vorname("John").nachname("Rambo").build(),
			PersonDTO.builder().id("3").vorname("John").nachname("McClain").build(),
			PersonDTO.builder().id("4").vorname("John").nachname("Wick").build()
	);

	@GetMapping(path = "/person", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<PersonDTO> getPerson() {
		PersonDTO result =  PersonDTO.builder().id("1").vorname("John").nachname("Doe").build();
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PersonDTO> getPersonByID(@PathVariable String id) {
		Optional<PersonDTO> myOptional = personen.stream().filter(p->p.getId().equals(id)).findFirst();
		return ResponseEntity.of(myOptional);
	}
	
	
	@GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<PersonDTO>> getAllPersons(
			@RequestParam(required = false, defaultValue = "") String vorname,
			@RequestParam(required = false, defaultValue = "") String nachname) {
		// Filtern fehlt
		return ResponseEntity.ok(personen);
	}
	
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deletePersonById(@PathVariable String id) {
		Optional<PersonDTO> myOptional = personen.stream().filter(p->p.getId().equals(id)).findFirst();
		if(myOptional.isPresent()) {
			log.warn("person wurde gelöscht " + myOptional.get());
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveOrUpdate(@Valid @RequestBody PersonDTO person) {
		System.out.println("person wird gespeichert: " + person);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
//	@PostMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Void> saveOrUpdateNotIdempotent(@RequestBody PersonDTO person,  UriComponentsBuilder builder) {
//		person.setId(UUID.randomUUID().toString());
//		
//		UriComponents uriComponent = builder.path("/v1/personen/{id}").buildAndExpand(person.getId());
//		
//		
//		System.out.println("person wird gespeichert: " + person);
//		return ResponseEntity.created(uriComponent.toUri()).build();
//	}
	
}

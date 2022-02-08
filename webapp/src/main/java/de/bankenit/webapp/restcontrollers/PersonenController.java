package de.bankenit.webapp.restcontrollers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import de.bankenit.webapp.restcontrollers.dtos.PersonDTO;
import de.bankenit.webapp.restcontrollers.mappers.PersonDTOMapper;
import de.bankenit.webapp.services.PersonenService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/personen")
@Slf4j
@AllArgsConstructor
public class PersonenController {

	private final PersonenService service;
	private final PersonDTOMapper mapper;

	
	@ApiResponse(responseCode = "200", description = "Person wurde gefunden")
    @ApiResponse(responseCode = "404", description = "Person wurde nicht gefunden" )
	@ApiResponse(responseCode = "400", description = "Bad Request" )
	@ApiResponse(responseCode = "500", description = "Interner Serverfehler")
	@GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<PersonDTO> getPersonByID(@PathVariable String id) throws Exception {
		
		return ResponseEntity.of(service.findeNachId(id).map(mapper::convert));
	}
	
	
	@GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<PersonDTO>> getAllPersons(
			@RequestParam(required = false, defaultValue = "") String vorname,
			@RequestParam(required = false, defaultValue = "") String nachname)throws Exception {
		// Filtern fehlt
		return ResponseEntity.ok(mapper.convert(service.findeAlle()));
	}
	
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deletePersonById(@PathVariable String id) throws Exception{
		if(service.loeschen(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path = "", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> saveOrUpdate(@Valid @RequestBody PersonDTO person) throws Exception{
		if(service.speichernOderEinfuegen(mapper.convert(person)))
			return ResponseEntity.ok().build();
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
	
	@PostMapping(path = "/to-upper", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonDTO> toUpper(@RequestBody  PersonDTO source) {
        source.setVorname(source.getVorname().toUpperCase());
        source.setNachname(source.getNachname().toUpperCase());
        return ResponseEntity.ok(source);
    }
	
//	@PutMapping(path = "/{id}/to-upper")
//	public ResponseEntity<Void> toUpperById(@PathVariable String id) {
//        // Serviceaufruf zum Ändern
//        return ResponseEntity.ok().build(); // ggf. NotFound
//    }
	

}

package de.bankenit.webapp.restcontrollers;

import javax.validation.Valid;

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

import de.bankenit.webapp.restcontrollers.dtos.SchweinDTO;
import de.bankenit.webapp.restcontrollers.mappers.SchweinDTOMapper;
import de.bankenit.webapp.services.SchweineService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/v1/schweine")
@AllArgsConstructor
public class SchweineController {
    private final SchweineService service;
    private final SchweinDTOMapper mapper;

    @ApiResponse(responseCode = "200", description = "Schwein wurde gefunden")
    @ApiResponse(responseCode = "404", description = "Schwein wurde nicht gefunden")
    @ApiResponse(responseCode = "400", description = "Bad Request" )
    @ApiResponse(responseCode = "500", description = "Interner Serverfehler")
    @GetMapping(path= "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<SchweinDTO> findeSchweinByID(@PathVariable String id) throws Exception{

        return ResponseEntity.of(service.findeZuId(id).map(mapper::convert));

    }
    @ApiResponse(responseCode = "200", description = "Liste wurde erstellt")
    @ApiResponse(responseCode = "400", description = "Bad Request" )
    @ApiResponse(responseCode = "500", description = "Interner Serverfehler")
    @GetMapping(path= "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Iterable<SchweinDTO>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam (required = false, defaultValue = "0") int gewicht
    )throws Exception{



        return ResponseEntity.ok(mapper.convert(service.findeAlle()));

    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> delete(@PathVariable  String id)throws Exception{
        if(service.loesche(id)) {

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping(path="", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrUpdate(@Valid @RequestBody SchweinDTO dto, UriComponentsBuilder builder) throws Exception{
        if(! service.speichere(mapper.convert(dto))) {
            UriComponents component = builder.path("/v1/schweine/{id}").buildAndExpand(dto.getId());
            return ResponseEntity.created(component.toUri()).build();
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping(path="/{id}/fuettere")
    public ResponseEntity<Void> feed(@PathVariable String id) throws Exception{
        if( service.fuettere(id)){

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }



}
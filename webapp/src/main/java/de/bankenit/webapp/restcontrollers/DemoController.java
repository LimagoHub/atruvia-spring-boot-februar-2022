package de.bankenit.webapp.restcontrollers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.bankenit.webapp.XYZ;
import de.bankenit.webapp.restcontrollers.dtos.PersonDTO;

@RestController
@RequestMapping("/v1/demo")
public class DemoController {
	
	@Autowired
	XYZ xyz;
	
	@GetMapping("/gruss")
	public String fritz() {
		return "Hallo Welt!";
	}
	@GetMapping("/uuid")
	public String getUUID() {
		return UUID.randomUUID().toString();
	}
	
}

package de.bankenit.webapp;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Demo {

	@Value("${Demo.message}")
	private String message = "Hallo Java"; 
	
	@Autowired
	@Qualifier("stadtLandFluss")
	private List<String> stadtLandFluss;
	
	public Demo() {
		System.out.println(message);
	}
	@PostConstruct
	public void run() {
		System.out.println(stadtLandFluss);
	}

}

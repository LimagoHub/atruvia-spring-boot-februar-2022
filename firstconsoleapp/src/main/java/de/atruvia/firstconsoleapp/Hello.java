package de.atruvia.firstconsoleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import de.atruvia.firstconsoleapp.demo.Demo;

//@Component
@Order(2)
public class Hello implements  CommandLineRunner{

	
	private final Demo demo;
	
	
	//@Autowired
	public Hello(Demo demo) {
		
		this.demo = demo;
	}



	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hallo Welt");
		
		demo.run();
		
	}

}

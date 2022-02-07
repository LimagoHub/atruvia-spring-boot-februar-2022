package de.atruvia.firstconsoleapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import de.atruvia.firstconsoleapp.demo.Demo;


//@Component
@Order(1)
public class SecondRunner implements CommandLineRunner {

	@Autowired
	private Demo demo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Ich auch");
		demo.run();
	}

}

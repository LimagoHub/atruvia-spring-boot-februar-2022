package de.atruvia.firstconsoleapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import de.atruvia.firstconsoleapp.client.CalcClient;

@Component
public class CalculatorDemo implements CommandLineRunner {

	
	
	private final CalcClient client;
	



	public CalculatorDemo(CalcClient client) {
		super();
		this.client = client;
	}




	@Override
	public void run(String... args) throws Exception {
		
		client.run();

	}

}

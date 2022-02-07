package de.atruvia.firstconsoleapp.client;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import de.atruvia.firstconsoleapp.math.Calculator;

@Component
public class CalcClient {

	private final Calculator calculator;
	
	
	
	public CalcClient(@Qualifier("secure") final Calculator calculator) {
		this.calculator = calculator;
	}



	public void run() {
		
		System.out.println(calculator.add(3,4));

	}

}

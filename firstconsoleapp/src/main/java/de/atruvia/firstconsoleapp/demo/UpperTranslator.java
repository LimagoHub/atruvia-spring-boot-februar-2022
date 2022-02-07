package de.atruvia.firstconsoleapp.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("upper")
public class UpperTranslator implements Translator{

	@Override
	public String translate(String message) {
		
		return message.toUpperCase();
	}
	
	

}

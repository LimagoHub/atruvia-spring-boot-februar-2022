package de.atruvia.firstconsoleapp.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("lower")
public class LowerTranslator implements Translator {

	@Override
	public String translate(String message) {
		// TODO Auto-generated method stub
		return message.toLowerCase();
	}

}

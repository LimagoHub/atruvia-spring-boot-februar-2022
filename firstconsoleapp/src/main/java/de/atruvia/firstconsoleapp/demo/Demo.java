package de.atruvia.firstconsoleapp.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // default
//@Lazy
public class Demo {
	
	
	
	private Translator translator;
	
	public Demo(@Qualifier("lower") Translator translator) {
		this.translator = translator;
		System.out.println("Constructor demo");
		
	}
	
	public void run() {
		System.out.println(translator.translate("Hallo Demo: " + this));
	}
	
	@PostConstruct
	public void fritz() {
		System.out.println(translator.translate("Init fertig"));
	}
	
	@PreDestroy
	public void herbert() {
		System.out.println(translator.translate("Und tschüss..."));
	}
}

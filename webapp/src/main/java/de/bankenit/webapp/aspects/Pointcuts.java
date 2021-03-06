package de.bankenit.webapp.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {
	
	@Pointcut("execution(public * de.bankenit.webapp.restcontrollers.PersonenController.*(..))")
	public void personenControllerMethodes(){}
	
	 @Pointcut(value = "within(@org.springframework.web.bind.annotation.RestController *)" )
	 public void restControllerMethodes() {}
	
}

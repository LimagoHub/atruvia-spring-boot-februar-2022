package de.bankenit.webapp.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import de.bankenit.webapp.restcontrollers.dtos.PersonDTO;
import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LoggerAspect {
	

	@Before("Pointcuts.personenControllerMethodes()")
	public void logAdvice(JoinPoint joinPoint) {
		log.warn(joinPoint.getSignature().getName() + " wurde gerufen");
	}
	@AfterReturning(value = "Pointcuts.personenControllerMethodes()",returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		log.warn(result.toString());
	}
	@AfterThrowing(value = "execution(public * de.bankenit.webapp.restcontrollers.PersonenController.*(..))",throwing = "ex")
	 public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
	        log.error("Fehler {} ist aufgetreten", ex);
	    }
	
	@Around("execution(public * de.bankenit.webapp.restcontrollers.PersonenController.*(..))")
	public Object benchmark(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		Object result = proceedingJoinPoint.proceed();
		
		return result;
	}
}

package de.bankenit.webapp.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.bankenit.webapp.repositories.PersonenRepository;
import de.bankenit.webapp.services.PersonenServiceException;
import de.bankenit.webapp.services.mappers.PersonMapper;
import de.bankenit.webapp.services.model.Person;

@ExtendWith(MockitoExtension.class)
public class PersonenServiceImplTest {
	
	@InjectMocks
	private PersonenServiceImpl objectUnderTest;
	
	@Mock
	private PersonenRepository repoMock;
	@Mock
	private PersonMapper mapperMock;
	
	@Mock
	private List<String> antipathenMock;

	private final Person validPerson = Person.builder().id("012345678901234567890123456789012345").vorname("John").nachname("Doe").build();

	@Test
	void speichernOderEinfuegen_parameterNull_throwsPersonenServiceException() {
		 // Arrange

        // Act & Assert
        PersonenServiceException ex = assertThrows(PersonenServiceException.class,()->objectUnderTest.speichernOderEinfuegen(null));
        // Assertion
        assertEquals("Person darf nicht null sein", ex.getMessage());
	}
	
}

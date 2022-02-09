package de.bankenit.webapp.services;

import java.util.Optional;

import de.bankenit.webapp.services.model.Schwein;

public interface SchweineService {

	boolean speichere(Schwein schwein) throws SchweineServiceException;

	Optional<Schwein> findeZuId(String id) throws SchweineServiceException;

	Iterable<Schwein> findeAlle() throws SchweineServiceException;

	boolean loesche(String id) throws SchweineServiceException;

	boolean fuettere(String id) throws SchweineServiceException;
}

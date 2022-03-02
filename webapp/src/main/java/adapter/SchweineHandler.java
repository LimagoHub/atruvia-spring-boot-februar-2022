package adapter;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.bankenit.webapp.services.SchweineService;
import de.bankenit.webapp.services.SchweineServiceException;
import lombok.AllArgsConstructor;

@Component
@Transactional(rollbackFor = SchweineServiceException.class)
@AllArgsConstructor
public class SchweineHandler {

	private SchweineService service;
	
	public void handleFressen(String id) throws SchweineServiceException{
		try {
			service.fuettere(id);
			// PigFeededEvent
		} catch (SchweineServiceException e) {
			// UppsEvent
			throw e;
		}
	}
}

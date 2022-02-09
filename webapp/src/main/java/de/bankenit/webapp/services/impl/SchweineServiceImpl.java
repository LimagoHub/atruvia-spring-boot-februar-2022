package de.bankenit.webapp.services.impl;



import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.bankenit.webapp.repositories.SchweinRepository;
import de.bankenit.webapp.services.SchweineService;
import de.bankenit.webapp.services.SchweineServiceException;
import de.bankenit.webapp.services.mappers.SchweinMapper;
import de.bankenit.webapp.services.model.Schwein;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = SchweineServiceException.class, isolation = Isolation.READ_COMMITTED)
public class SchweineServiceImpl implements SchweineService {

    private final SchweinRepository repo;
    private final SchweinMapper mapper;

    @Override
    public boolean speichere(Schwein schwein) throws SchweineServiceException {
        try {
            boolean result = repo.existsById(schwein.getId());
            repo.save(mapper.convert(schwein));
            return result;
        } catch (Exception e) {
            throw new SchweineServiceException("upps", e);
        }
    }

    @Override
    public Optional<Schwein> findeZuId(String id) throws SchweineServiceException {
        try {
            return repo.findById(id).map(mapper::convert);
        } catch (Exception e) {
            throw new SchweineServiceException("upps", e);
        }
    }

    @Override
    public Iterable<Schwein> findeAlle() throws SchweineServiceException {
        try {
            return mapper.convert(repo.findAll());
        } catch (Exception e) {
            throw new SchweineServiceException("upps", e);
        }
    }

    @Override
    public boolean loesche(String id) throws SchweineServiceException {
        try {
            if( repo.existsById(id)) {
                repo.deleteById(id);
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new SchweineServiceException("upps", e);
        }
    }

    @Override
    public boolean fuettere(String id) throws SchweineServiceException {
      
            Optional<Schwein> optional = findeZuId(id);
            if(optional.isPresent()) {
                Schwein s = optional.get();
                s.fressen();
                speichere(s);
                return true;
            }
            return false;
       
    }
}

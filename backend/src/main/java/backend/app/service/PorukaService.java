package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Poruka;
import backend.app.repository.PorukaRepository;

@Service
public class PorukaService {

    @Autowired
    private PorukaRepository porukaRepo;

    public PorukaService() {
    }

    public Iterable<Poruka> getPoruka() {
        return porukaRepo.findAll();
    }
    
    public Iterable<Poruka> getPorukaByUser(String username) {
        return porukaRepo.findByPrimalacOrPosiljalac(username, username);
    }

    public Optional<Poruka> getPorukaById(Long id) {
        return porukaRepo.findById(id);
    }

    public void addPoruka(Poruka poruka) {
    	String primalacUsername = poruka.getPrimalac();
    	String posiljalacUsername = poruka.getPosiljalac();
    	if(primalacUsername != null && posiljalacUsername != null) {
    		poruka.setPrimalac(primalacUsername);
    		poruka.setPosiljalac(posiljalacUsername);
    		porukaRepo.save(poruka);
    	}
    }

    public void removePoruka(Long id) {
        Optional<Poruka> poruka = porukaRepo.findById(id);
        porukaRepo.delete(poruka.get());
    }

    public void updatePoruka(Long id, Poruka poruka) {
        Optional<Poruka> Mes = porukaRepo.findById(id);
        if(Mes.isPresent()) {
        	poruka.setId(Mes.get().getId());
        	porukaRepo.save(poruka);
        }
    }

}


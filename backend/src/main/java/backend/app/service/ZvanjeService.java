package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Zvanje;
import backend.app.repository.ZvanjeRepository;

@Service
public class ZvanjeService {

    @Autowired
    private ZvanjeRepository zvanjeRepo;

    public ZvanjeService() {
    }

    public Iterable<Zvanje> getZvanje() {
        return zvanjeRepo.findAll();
    }

    public Optional<Zvanje> getZvanjeById(Long id) {
        return zvanjeRepo.findById(id);
    }

    public void addZvanje(Zvanje zvanje) {
    	zvanjeRepo.save(zvanje);
    }

    public void removeZvanje(Long id) {
        Optional<Zvanje> zvanje = zvanjeRepo.findById(id);
        zvanjeRepo.delete(zvanje.get());
    }

	public void updateZvanje(Long id,Zvanje zvanje) {
		Optional<Zvanje> zva = zvanjeRepo.findById(id);
		if(zva.isPresent()) {
			zvanje.setId(zva.get().getId());
			zvanjeRepo.save(zvanje);
		}
	}

}

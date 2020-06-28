package backend.app.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Uloga;
import backend.app.repository.UlogaRepository;

@Service 
public class UlogaService {

	@Autowired
	UlogaRepository ulogaRepo;
	
	public Iterable<Uloga> getUloga() {
		return ulogaRepo.findAll();
	}
	
	public Optional<Uloga> getOne(Long id) {
		return ulogaRepo.findById(id);
	}
	
	public void addUloga(Uloga uloga) {
		ulogaRepo.save(uloga);
	}
	
	public void removeUloga(Long id) {
		Optional<Uloga> ulg = ulogaRepo.findById(id);
		if(ulg.isPresent()) {
			ulogaRepo.delete(ulg.get());
		}
	}
	public void updateUloga(Long id, Uloga uloga) {
		Optional<Uloga> ulg = ulogaRepo.findById(id);
		if(ulg.isPresent()) {
			uloga.setId(ulg.get().getId());
			ulogaRepo.save(uloga);
		}
	}

}


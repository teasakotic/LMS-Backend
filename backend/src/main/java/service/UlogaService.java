package service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Uloga;
import repository.UlogaRepository;

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
}

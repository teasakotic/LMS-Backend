package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Drzava;
import backend.app.repository.DrzavaRepository;

@Service 
public class DrzavaService {

	@Autowired
	DrzavaRepository drzavaRepo;
	
	public Iterable<Drzava> getDrzava() {
		return drzavaRepo.findAll();
	}
	
	public Optional<Drzava> getOne(Long id) {
		return drzavaRepo.findById(id);
	}
	
	public void addDrzava(Drzava drzava) {
		drzavaRepo.save(drzava);
	}
	
	public void removeDrzava(Long id) {
		Optional<Drzava> drz = drzavaRepo.findById(id);
		if(drz.isPresent()) {
			drzavaRepo.delete(drz.get());
		}
	}
	public void updateDrzava(Long id, Drzava drzava) {
		Optional<Drzava> drz = drzavaRepo.findById(id);
		if(drz.isPresent()) {
			drzava.setId(drz.get().getId());
			drzavaRepo.save(drzava);
		}
	}

}

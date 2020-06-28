package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Mesto;
import backend.app.repository.MestoRepository;

@Service 
public class MestoService {

	@Autowired
	MestoRepository mestoRepo;
	
	public Iterable<Mesto> getAdresa() {
		return mestoRepo.findAll();
	}
	
	public Optional<Mesto> getOne(Long id) {
		return mestoRepo.findById(id);
	}
	
	public void addMesto(Mesto mesto) {
		mestoRepo.save(mesto);
	}
	
	public void removeMesto(Long id) {
		Optional<Mesto> mess= mestoRepo.findById(id);
		if(mess.isPresent()) {
			mestoRepo.delete(mess.get());
		}
	}
	
	public void updateMesto(Long id, Mesto mesto) {
		Optional<Mesto> mess = mestoRepo.findById(id);
		if(mess.isPresent()) {
			mesto.setId(mess.get().getId());
			mestoRepo.save(mesto);
		}
	}

}

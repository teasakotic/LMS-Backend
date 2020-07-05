package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Telefon;
import backend.app.repository.TelefonRepository;



@Service 
public class TelefonService {

	@Autowired
	TelefonRepository telefonRepo;
	
	public Iterable<Telefon> getTelefon() {
		return telefonRepo.findAll();
	}
	
	public Optional<Telefon> getTelefonById(Long id) {
		return telefonRepo.findById(id);
	}
	
	public void addTelefon(Telefon telefon) {
		telefonRepo.save(telefon);
	}
	
	public void removeTelefon(Long id) {
		Optional<Telefon> tel = telefonRepo.findById(id);
		if(tel.isPresent()) {
			telefonRepo.delete(tel.get());
		}
	}
	public void updateTelefon(Long id, Telefon telefon) {
		Optional<Telefon> tel = telefonRepo.findById(id);
		if(tel.isPresent()) {
			telefon.setId(tel.get().getId());
			telefonRepo.save(telefon);
		}
	}

}
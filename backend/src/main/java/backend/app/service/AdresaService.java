package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.Adresa;
import backend.app.repository.AdresaRepository;

@Service 
public class AdresaService {

	@Autowired
	AdresaRepository adresaRepo;
	
	public Iterable<Adresa> getAdresa() {
		return adresaRepo.findAll();
	}
	
	public Optional<Adresa> getOne(Long id) {
		return adresaRepo.findById(id);
	}
	
	public void addAdresa(Adresa adresa) {
		adresaRepo.save(adresa);
	}
	
	public void removeAdresa(Long id) {
		Optional<Adresa> adresss= adresaRepo.findById(id);
		if(adresss.isPresent()) {
			adresaRepo.delete(adresss.get());
		}
	}
	
	public void updateAdresa(Long id, Adresa adresa) {
		Optional<Adresa> adresss = adresaRepo.findById(id);
		if(adresss.isPresent()) {
			adresa.setId(adresss.get().getId());
			adresaRepo.save(adresa);
		}
	}

}

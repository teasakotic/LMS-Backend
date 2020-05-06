package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.KategorijaUloga;
import repository.KategorijaUlogaRepository;

@Service 
public class KategorijaUlogaService {

	@Autowired
	KategorijaUlogaRepository kategorijaUlogaRepo;
	
	public Iterable<KategorijaUloga> getKategorijaUloga() {
		return kategorijaUlogaRepo.findAll();
	}
	
	public Optional<KategorijaUloga> getOne(Long id) {
		return kategorijaUlogaRepo.findById(id);
	}
	
	public void addKategorijaUloga(KategorijaUloga kategorijaUloga) {
		kategorijaUlogaRepo.save(kategorijaUloga);
	}
	
	public void removeKategorijaUloga(Long id) {
		Optional<KategorijaUloga> kate= kategorijaUlogaRepo.findById(id);
		if(kate.isPresent()) {
			kategorijaUlogaRepo.delete(kate.get());
		}
	}
	
	public void updateKategorijaUloga(Long id, KategorijaUloga kategorijaUloga) {
		Optional<KategorijaUloga> kate = kategorijaUlogaRepo.findById(id);
		if(kate.isPresent()) {
			kategorijaUloga.setId(kate.get().getId());
			kategorijaUlogaRepo.save(kategorijaUloga);
		}
	}

}

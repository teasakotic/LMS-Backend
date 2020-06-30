package backend.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.app.model.NaucnaOblast;
import backend.app.repository.NaucnaOblastRepository;

@Service 
public class NaucnaOblastService {

	@Autowired
	NaucnaOblastRepository naucnaOblastRepo;
	
	public Iterable<NaucnaOblast> getNaucnaOblast() {
		return naucnaOblastRepo.findAll();
	}
	
	public Optional<NaucnaOblast> getNaucnaOblastById(Long id) {
		return naucnaOblastRepo.findById(id);
	}
	
	public void addNaucnaOblast(NaucnaOblast naucnaOblast) {
		naucnaOblastRepo.save(naucnaOblast);
	}
	
	public void removeNaucnaOblast(Long id) {
		Optional<NaucnaOblast> nauc= naucnaOblastRepo.findById(id);
		if(nauc.isPresent()) {
			naucnaOblastRepo.delete(nauc.get());
		}
	}
	
	public void updateNaucnaOblast(Long id, NaucnaOblast naucnaOblast) {
		Optional<NaucnaOblast> nauc = naucnaOblastRepo.findById(id);
		if(nauc.isPresent()) {
			naucnaOblast.setId(nauc.get().getId());
			naucnaOblastRepo.save(naucnaOblast);
		}
	}

}
